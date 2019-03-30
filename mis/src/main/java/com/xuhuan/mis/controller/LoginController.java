package com.xuhuan.mis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

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
     * 登陆
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/logOn", method = RequestMethod.GET)
    private String logOn(ModelMap model, HttpServletRequest request) {
        return "framework/main";
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
