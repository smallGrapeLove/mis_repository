package com.xuhuan.mis.controller;

import com.xuhuan.mis.entity.User;
import com.xuhuan.mis.service.IRoleService;
import com.xuhuan.mis.service.IUserService;
import com.xuhuan.mis.util.common.NumberTool;
import com.xuhuan.mis.util.common.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    private Logger logger = Logger.getLogger(UserController.class);

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
        model.addAttribute("roleList", roleList);
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
        modelMap.addAttribute("roleList", roleList);
        return "user/user_edit";
    }

    /**
     * 保存用户
     *
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

    /**
     * 修改密码
     *
     * @return
     */
    @RequestMapping(value = "/password/toEdit", method = RequestMethod.GET)
    public String toEditPassword() {
        return "user/user_edit_password";
    }

    /**
     * 保存密码
     *
     * @param paramMap
     * @return
     */
    @RequestMapping(value = "/password/save", method = RequestMethod.POST)
    public String saveEditPassword(@RequestParam Map paramMap,RedirectAttributes attr) {
        int userId = NumberTool.safeToInteger(paramMap.get("userId"), 0);
        String oldPassword = StringUtil.safeToString(paramMap.get("oldPassword"), "");
        String newPassword = StringUtil.safeToString(paramMap.get("newPassword"), "");
        String rNewPassword = StringUtil.safeToString(paramMap.get("rNewPassword"), "");

        String changeUserPsdMsg="";
        if (userId != 0) {
            User user = userService.getUserById(userId);
            if (user != null) {
                String password = StringUtil.safeToString(user.getPassword(), "");
                if (password.equals(oldPassword)) {
                    user.setPassword(newPassword);
                    userService.saveUser(user);
                    logger.info("[" + user.getShowName() + "]修改密码成功");
                    changeUserPsdMsg="密码修改成功";
                }else {
                    changeUserPsdMsg="旧密码错误";
                }
            }else {
                changeUserPsdMsg="获取当前用户信息失败";
            }
        }else {
            changeUserPsdMsg="获取当前用户失败";
        }
        if(StringUtil.isNotBlank(changeUserPsdMsg)){

            attr.addFlashAttribute("changeUserPsdMsg",changeUserPsdMsg);
        }
        return "redirect:/user/password/toEdit";
    }
}
