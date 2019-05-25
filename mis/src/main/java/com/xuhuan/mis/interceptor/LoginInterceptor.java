package com.xuhuan.mis.interceptor;

import com.xuhuan.mis.entity.User;
import com.xuhuan.mis.util.common.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 *
 * @author huan.xu
 * @Time 2019-03-30 20:24
 */
public class LoginInterceptor implements HandlerInterceptor {

    private Logger logger = Logger.getLogger(LoginInterceptor.class);

    /**
     * 拦截器最先执行的方法,是在请求到达Controller之前执行的,其实就是拦截器用于拦截请求的
     *
     * @param request
     * @param response
     * @param handelr
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handelr) throws Exception {
        logger.info("拦截到请求：[" + request.getRequestURL() + "]，handelr：[" + handelr + "]");
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if (loginUser != null) {
            return true;
        }
        //不符合条件的给出提示信息，并转发到登录页面
        request.setAttribute("errorMsg", "您还没有登录，请先登录！");
        request.getRequestDispatcher("/login").forward(request, response);
        return false;
    }

    /**
     * 后端控制器controller处理完请求之后,就执行的
     *
     * @param request
     * @param response
     * @param handelr
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handelr, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 拦截器最后执行的方法
     *
     * @param request
     * @param response
     * @param handelr
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handelr, Exception e) throws Exception {

    }
}
