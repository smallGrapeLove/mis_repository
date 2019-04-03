package com.xuhuan.mis.controller;

import com.xuhuan.mis.entity.User;
import com.xuhuan.mis.service.IMenuService;
import com.xuhuan.mis.service.IUserService;
import com.xuhuan.mis.util.common.NumberTool;
import com.xuhuan.mis.util.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 系统登录controller
 *
 * @author huan.xu
 * @Time 2019-2-27
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IMenuService menuService;

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    private String toLogin() {
        return "login";
    }

    /**
     * 登录系统
     *
     * @param paramMap
     * @param session
     * @param attr
     * @return
     */
    @RequestMapping(value = "/logOn", method = RequestMethod.POST)
    private String logOn(@RequestParam Map<String, String> paramMap, HttpSession session, RedirectAttributes attr) {
        String userName = StringUtil.safeToString(paramMap.get("userName"), "");
        String password = StringUtil.safeToString(paramMap.get("password"), "");
        String errorMsg = "";
        if (StringUtil.isNotBlank(userName)) {
            User user = userService.getUserByUserName(userName);
            if (user != null) {
                String userPassword = StringUtil.safeToString(user.getPassword(), "");
                if (userPassword.equals(password)) {
                    session.setAttribute("loginUser", user);
                    return "framework/main";
                } else {
                    errorMsg = "密码错误";
                }
            } else {
                errorMsg = "用户不存在";
            }
            attr.addFlashAttribute("userName", userName);
            attr.addFlashAttribute("password", password);
        }
        if (StringUtil.isNotBlank(errorMsg)) {
            attr.addFlashAttribute("errorMsg", errorMsg);
        }
        return "redirect:/login";
    }

    /**
     * 退出系统
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "logOut", method = RequestMethod.GET)
    public String logOut(HttpSession session) {
        //清除session
        session.invalidate();
        //重定向到登录请求
        return "redirect:/login";
    }

    @RequestMapping(value = "/left", method = RequestMethod.GET)
    private String toLeft(HttpServletRequest request) {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if(loginUser!=null){
            int roleId = NumberTool.safeToInteger(loginUser.getRoleId(), 0);
            if(roleId!=0){
                List<Map> leftMenuData = menuService.makeLeftPageData(roleId);
                request.setAttribute("leftMenuData",leftMenuData);
            }
        }

        return "framework/left";
    }

    @RequestMapping(value = "/top", method = RequestMethod.GET)
    private String toTop(HttpServletRequest request) {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if(loginUser!=null){
            int roleId = NumberTool.safeToInteger(loginUser.getRoleId(), 0);
            if(roleId!=0){
                List<Map> topMenuList = menuService.getAuthMenuByParentId(roleId,0);
                request.setAttribute("topMenuList", topMenuList);
            }
        }
        return "framework/top";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    private String toIndex() {
        return "framework/index";
    }
}
