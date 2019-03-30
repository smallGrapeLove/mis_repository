package com.xuhuan.mis.controller;

import com.xuhuan.mis.entity.User;
import com.xuhuan.mis.service.IRoleService;
import com.xuhuan.mis.service.IUserService;
import com.xuhuan.mis.util.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户controller
 *
 * @author huan.xu
 * @Time 2019-02-27 17:32
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String toList(ModelMap model, @RequestParam Map paramMap) {
        List<Map> dataList = userService.getTableQuery(paramMap);
        model.addAttribute("dataList", dataList);
        model.addAttribute("paramMap", paramMap);

        List<Map> roleList = roleService.getTableQuery(new HashMap());
        model.addAttribute("roleList",roleList);
        return "user/user_list";
    }

    @RequestMapping(value = "/toEdit/{id}", method = RequestMethod.GET)
    public String toEdit(@PathVariable int id, ModelMap modelMap, HttpServletRequest request) {
        if (id != 0) {
            modelMap.addAttribute("id", id);
            User entity = userService.getUserById(id);
            if (entity != null) {
                modelMap.addAttribute("entity", entity);
            }
        }
        List<Map> roleList = roleService.getTableQuery(new HashMap());
        modelMap.addAttribute("roleList",roleList);
        return "user/user_edit";
    }

    /**
     * @param paramMap
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam Map paramMap) {
        userService.saveFormData(paramMap);
        return "redirect:/user/list";
    }

    /**
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request) {
        String ids = StringUtil.safeToString(request.getParameter("ids"), "");
        if (StringUtil.isNotBlank(ids)) {
            userService.deleteUser(StringUtil.subEndFlag(ids, ","));
        }
        return "redirect:/user/list";
    }
}
