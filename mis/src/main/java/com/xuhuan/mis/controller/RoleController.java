package com.xuhuan.mis.controller;


import com.xuhuan.mis.entity.Role;
import com.xuhuan.mis.service.IRoleService;
import com.xuhuan.mis.util.common.NumberTool;
import com.xuhuan.mis.util.common.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色controller
 *
 * @author huan.xu
 * @Time 2019-2-27
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    private Logger log = Logger.getLogger(RoleController.class);

    @Resource
    private IRoleService roleService;

    /**
     * 角色列表
     *
     * @param paramMap
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String toList(ModelMap model, @RequestParam Map<String, String> paramMap) {
        List<Map> dataList=roleService.getTableQuery(paramMap);
        model.addAttribute("dataList",dataList);
        model.addAttribute("paramMap",paramMap);
        return "role/role_list";
    }

    /**
     * 跳转角色编辑
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/toEdit/{id}", method = RequestMethod.GET)
    public String toEdit(@PathVariable int id, ModelMap model, HttpServletRequest request) {
        if (id != 0) {
            model.addAttribute("id", id);
            Role role = roleService.getRoleById(id);
            if (role != null) {
                model.addAttribute("role", role);
            }
        }
        return "role/role_edit";
    }

    /**
     * 保存角色
     *
     * @param paramMap
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam Map<String, String> paramMap) {
        roleService.saveFormData(paramMap);
        return "redirect:/role/list";
    }

    /**
     * 删除角色
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request){
        String ids = StringUtil.safeToString(request.getParameter("ids"), "");
        if(StringUtil.isNotBlank(ids)){
            roleService.deleteRole(StringUtil.subEndFlag(ids,","));
        }
        return "redirect:/role/list";
    }

}
