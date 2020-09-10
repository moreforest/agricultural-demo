package com.example.interceptor;

import com.example.pojo.Admin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: Cao
 * @Description: 拦截器
 * @Date: 2020/9/9
 **/
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 认证
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 认证代码
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            // 用户没有登录
            response.sendRedirect(request.getContextPath() + "/login/loginPage");
            return false; //不放行
        }
        // 放行
        return true;
    }
}
