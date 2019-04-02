package com.xuhuan.mis.controller;

import com.xuhuan.mis.entity.Menu;
import com.xuhuan.mis.service.IMenuService;
import com.xuhuan.mis.service.IRoleService;
import com.xuhuan.mis.util.common.NumberTool;
import com.xuhuan.mis.util.common.StringUtil;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单controller
 *
 * @author huan.xu
 * @Time 2019-02-27 17:32
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    private Logger log = Logger.getLogger(MenuController.class);

    @Resource
    private IMenuService menuService;
    @Autowired
    private IRoleService roleService;

    /**
     * 菜单列表
     *
     * @param paramMap
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String toList(ModelMap model, @RequestParam Map<String, String> paramMap) {
        List<Map> dataList = menuService.getTableQuery(paramMap);
        Map selectOptionMap = menuService.makeSelectOption(false);
        model.addAttribute("selectOptionMap", selectOptionMap);
        model.addAttribute("dataList", dataList);
        model.addAttribute("paramMap", paramMap);
        return "menu/menu_list";
    }

    /**
     * 跳转到角色菜单配置页面
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/menu-role",method = RequestMethod.GET)
    public String toEditRoleMenu(ModelMap modelMap){
        List<Map> roleList = roleService.getTableQuery(new HashMap());
        modelMap.addAttribute("roleList",roleList);
        return "menu/menu_role_edit";
    }

    /**
     * 获取角色菜单数据
     * @param request
     * @return
     */
    @RequestMapping(value = "/menu-role/getMenuData",method = RequestMethod.POST)
    @ResponseBody
    public Object getMenuData(HttpServletRequest request){
        int roleId = NumberTool.safeToInteger(request.getParameter("roleId"), 0);
        List<Map> roleMenuDataList=menuService.makeRoleMenuData(roleId);
        return JSONArray.fromObject(roleMenuDataList);
    }

    /**
     * 跳转菜单编辑
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/toEdit/{id}", method = RequestMethod.GET)
    public String toEdit(@PathVariable int id, ModelMap model, HttpServletRequest request) {
        if (id != 0) {
            model.addAttribute("id", id);
            Menu menu = menuService.getMenuById(id);
            if (menu != null) {
                model.addAttribute("entity", menu);
            }
        }
        Map selectOptionMap = menuService.makeSelectOption(false);
        model.addAttribute("selectOptionMap", selectOptionMap);
        return "menu/menu_edit";
    }

    /**
     * 保存菜单
     *
     * @param paramMap
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam Map<String, String> paramMap) {
        menuService.saveFormData(paramMap);
        return "redirect:/menu/list";
    }

    /**
     * 删除菜单
     *
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request) {
        String ids = StringUtil.safeToString(request.getParameter("ids"), "");
        if (StringUtil.isNotBlank(ids)) {
            menuService.deleteMenu(StringUtil.subEndFlag(ids, ","));
        }
        return "redirect:/menu/list";
    }
}
