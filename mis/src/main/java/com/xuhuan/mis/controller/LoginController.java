package com.xuhuan.mis.controller;

import com.xuhuan.mis.util.common.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 系统登陆controller
 *
 * @author huan.xu
 * @Time 2019-2-27
 */
@Controller
@RequestMapping("/login")
public class LoginController {


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
     * 登录按钮
     *
     * @param paramMap
     * @param session
     * @return
     */
    @RequestMapping(value = "/logOn", method = RequestMethod.GET)
    private String logOn(@RequestParam Map<String, String> paramMap, HttpSession session) {
        String userName = StringUtil.safeToString(paramMap.get("userName"), "");
        String password = StringUtil.safeToString(paramMap.get("password"), "");
        if (StringUtil.isNotBlank(userName)) {
            if ("admin".equals(userName)) {
                session.setAttribute("userName", userName);
                return "framework/main";
            }
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
    private String toLeft() {
        return "framework/left";
    }

    @RequestMapping(value = "/top", method = RequestMethod.GET)
    private String toTop() {
        return "framework/top";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    private String toIndex() {
        return "framework/index";
    }
}
