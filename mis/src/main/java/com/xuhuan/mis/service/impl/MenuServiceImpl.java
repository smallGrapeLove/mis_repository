package com.xuhuan.mis.service.impl;

import com.xuhuan.mis.dao.MenuDao;
import com.xuhuan.mis.dao.RoleMenuDao;
import com.xuhuan.mis.entity.Menu;
import com.xuhuan.mis.entity.RoleMenu;
import com.xuhuan.mis.service.IMenuService;
import com.xuhuan.mis.util.common.NumberTool;
import com.xuhuan.mis.util.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    @Autowired
    private RoleMenuDao roleMenuDao;

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
     * 根据上级菜单查询
     *
     * @param parentId
     * @return
     */
    @Override
    public List<Map> getMenuByParentId(int parentId) {
        return menuDao.selectByParentId(parentId);
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
        String imgName = StringUtil.safeToString(paramMap.get("imgName"), "");
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
        menu.setImgName(imgName);
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

    /**
     * 组装左侧导航栏数据
     *
     * @return
     */
    @Override
    public List<Map> makeLeftPageData() {
        List<Map> leftPageDataList = new ArrayList<>();
        List<Map> topMenuList = this.getMenuByParentId(0);
        if (topMenuList != null && topMenuList.size() > 0) {
            for (Map topMenu : topMenuList) {
                int topMenuId = NumberTool.safeToInteger(topMenu.get("id"), 0);
                List<Map> sMenuList = this.getMenuByParentId(topMenuId);
                Map topMenuMap = new HashMap();
                List<Map> childrenMenuList = new ArrayList<>();
                if (sMenuList != null && sMenuList.size() > 0) {
                    for (Map sMenu : sMenuList) {
                        Map sChildrenMap = new HashMap();
                        int id = NumberTool.safeToInteger(sMenu.get("id"), 0);
                        List<Map> tMenuList = this.getMenuByParentId(id);

                        sChildrenMap.put("sMenu", sMenu);
                        sChildrenMap.put("tChildrenMapList", tMenuList);

                        childrenMenuList.add(sChildrenMap);
                    }
                }
                topMenuMap.put("tMenu", topMenu);
                topMenuMap.put("sChildrenMapList", childrenMenuList);

                leftPageDataList.add(topMenuMap);
            }
        }
        return leftPageDataList;
    }

    /**
     * 组装角色权限数据
     * 角色菜单配置使用
     *
     * @param roleId
     * @return
     */
    @Override
    public List<Map> makeRoleMenuData(int roleId) {
        List<Map> roleMenuDataList = new ArrayList<>();
        List<Map> fMenuDataLIst = this.getMenuByParentId(0);
        if (fMenuDataLIst != null && fMenuDataLIst.size() > 0) {
            for (int f = 0; f < fMenuDataLIst.size(); f++) {
                Map _fMenuMap = new HashMap();
                Map fMenuMap = fMenuDataLIst.get(f);
                int fId = NumberTool.safeToInteger(fMenuMap.get("id"), 0);
                fMenuMap.put("hasPrivilege", this.checkRoleMenu(roleId, fId)+"");
                List<Map> sMenuDataList = this.getMenuByParentId(fId);
                List<Map> _sMenuDataList=new ArrayList<>();
                if (sMenuDataList != null && sMenuDataList.size() > 0) {
                    for (int s = 0; s < sMenuDataList.size(); s++) {
                        Map _sMenuMap=new HashMap();
                        Map sMenuMap = sMenuDataList.get(s);
                        int sId = NumberTool.safeToInteger(sMenuMap.get("id"), 0);
                        sMenuMap.put("hasPrivilege", this.checkRoleMenu(roleId, sId)+"");

                        List<Map> tMenuDataList = this.getMenuByParentId(sId);
                        if (tMenuDataList != null && tMenuDataList.size() > 0) {
                            for (int t = 0; t < tMenuDataList.size(); t++) {
                                Map tMenuMap = tMenuDataList.get(t);
                                int tId = NumberTool.safeToInteger(tMenuMap.get("id"), 0);
                                tMenuMap.put("hasPrivilege", this.checkRoleMenu(roleId, tId)+"");
                            }
                        }
                        _sMenuMap.put("sMenu",sMenuMap);
                        _sMenuMap.put("sChildren",tMenuDataList);
                        _sMenuDataList.add(_sMenuMap);
                    }
                }
                _fMenuMap.put("fMenu", fMenuMap);
                _fMenuMap.put("fChildren", _sMenuDataList);
                roleMenuDataList.add(_fMenuMap);
            }
        }
        return roleMenuDataList;
    }

    /**
     * 检查角色是否有此菜单权限
     *
     * @param roleId
     * @param menuId
     * @return
     */
    @Override
    public boolean checkRoleMenu(int roleId, int menuId) {
        Map searchMap = new HashMap(2);
        searchMap.put("roleId", roleId);
        searchMap.put("menuId", menuId);
        List<RoleMenu> roleMenus = roleMenuDao.selectByParam(searchMap);
        if (roleMenus != null && roleMenus.size() > 0) {
            return true;
        }
        return false;
    }
}
