package com.xuhuan.mis.service.impl;

import com.xuhuan.mis.dao.MenuDao;
import com.xuhuan.mis.entity.Menu;
import com.xuhuan.mis.service.IMenuService;
import com.xuhuan.mis.util.common.NumberTool;
import com.xuhuan.mis.util.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单service实现类
 *
 * @author huan.xu
 * @Time 2019-02-27 17:24
 */
@Service("IMenuService")
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuDao menuDao;

    /**
     * 列表查询
     *
     * @param paramMap
     * @return
     */
    @Override
    public List<Map> getTableQuery(Map<String, String> paramMap) {
        return menuDao.selectByParam(paramMap);
    }

    /**
     * 根据id查询菜单信息
     *
     * @param id
     * @return
     */
    @Override
    public Menu getMenuById(int id) {
        return menuDao.selectById(id);
    }

    /**
     * 保存表单数据
     *
     * @param paramMap
     */
    @Override
    public void saveFormData(Map paramMap) {
        int id = NumberTool.safeToInteger(paramMap.get("id"), 0);
        String name = StringUtil.safeToString(paramMap.get("name"), "");
        String url = StringUtil.safeToString(paramMap.get("url"), "");
        String sort = StringUtil.safeToString(paramMap.get("sort"), "");
        int parentId = NumberTool.safeToInteger(paramMap.get("parentId"), 0);

        Menu menu;
        if (id != 0) {
            menu = this.getMenuById(id);
        } else {
            menu = new Menu();
        }
        menu.setName(name);
        menu.setUrl(url);
        menu.setSort(sort);
        menu.setParentId(parentId);

        this.saveMenu(menu);
    }

    /**
     * 保存菜单信息
     *
     * @param menu
     */
    @Override
    public void saveMenu(Menu menu) {
        if (menu != null) {
            int id = NumberTool.safeToInteger(menu.getId(), 0);
            if (id != 0) {
                menuDao.update(menu);
            } else {
                menuDao.save(menu);
            }
        }
    }

    /**
     * 删除菜单
     *
     * @param idsStr 逗号分个的id字符串
     */
    @Override
    public void deleteMenu(String idsStr) {
        if (StringUtil.isNotBlank(idsStr)) {
            String[] idsArr = idsStr.split(",");
            for (String id : idsArr) {
                menuDao.delete(NumberTool.safeToInteger(id, 0));
            }
        }
    }

    /**
     * 组装下拉框选项
     *
     * @param showLastFlag 是否显示第三级菜单
     * @return
     */
    @Override
    public Map makeSelectOption(boolean showLastFlag) {
        Map resultMap = new LinkedHashMap();
        List<Map> firstMenuList = menuDao.selectByParentId(0);
        if (firstMenuList != null && firstMenuList.size() > 0) {
            for (Map firstMenu : firstMenuList) {
                int id = NumberTool.safeToInteger(firstMenu.get("id"), 0);
                String name = StringUtil.safeToString(firstMenu.get("name"), "");
                resultMap.put(id, "|----" + name);
                List<Map> secondMenuList = menuDao.selectByParentId(id);
                if (secondMenuList != null && secondMenuList.size() > 0) {
                    for (Map secondMenu : secondMenuList) {
                        int secondId = NumberTool.safeToInteger(secondMenu.get("id"), 0);
                        String secondName = StringUtil.safeToString(secondMenu.get("name"), "");
                        resultMap.put(secondId, "&nbsp;&nbsp;&nbsp;&nbsp;|----" + secondName);
                        if (showLastFlag) {
                            List<Map> thirdMenuList = menuDao.selectByParentId(secondId);
                            if (thirdMenuList != null && thirdMenuList.size() > 0) {
                                for (Map thirdMenu : thirdMenuList) {
                                    int thirdId = NumberTool.safeToInteger(thirdMenu.get("id"), 0);
                                    String thirdName = StringUtil.safeToString(thirdMenu.get("name"), "");
                                    resultMap.put(thirdId, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|----" + thirdName);
                                }
                            }
                        }
                    }
                }
            }
        }
        return resultMap;
    }
}
