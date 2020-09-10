package com.example.interceptor;

import com.example.mapper.admin.PermissionsMapper;
import com.example.pojo.Admin;
import com.example.pojo.Permissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: Cao
 * @Description: 权限拦截器
 * @Date: 2020/9/9
 **/
public class PermissionInterceptor implements HandlerInterceptor {

    @Autowired
    PermissionsMapper permissionsMapper;

    /**
     * 权限拦截器
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //权限   权限鉴定  登录成功后执行
        Admin admin = (Admin) request.getSession().getAttribute("admin");

        // 超级管理员 admin
        // 超级管理员直接放行
        if ("admin".equals(admin.getUsername())) {
            System.out.println("超级管理员直接放行!");
            return true;
        }

        // 获取用户访问URL
        String url = request.getRequestURI();

        // 获取用户所有权限
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        PermissionsMapper permissionsMapper = applicationContext.getBean(PermissionsMapper.class);

        List<Permissions> permissions = permissionsMapper.queryAllPermissionByUser(admin.getId());

        boolean isOk = false; // 默认无权限

        if (!CollectionUtils.isEmpty(permissions)) {
            for (Permissions p : permissions) {
                if (!StringUtils.isEmpty(p.getPermissionUrl())) {
                    if (url.contains(p.getPermissionUrl())) { //访问路径中 包含 权限路径
                        //有权限
                        isOk = true;
                        break;
                    }
                }
            }
        }
        if (isOk) {
            return true;
        } else {
            //没有权限
            System.out.println("没有权限!");
            response.sendRedirect(request.getContextPath() + "/noPermission");
            return false;
        }
    }

}
