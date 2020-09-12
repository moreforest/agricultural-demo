package com.example.config;

import com.example.interceptor.LoginInterceptor;
import com.example.interceptor.PermissionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Cao
 * @Description: 配置类
 * @Date: 2020/9/9
 **/
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 登录拦截  链式编程    以下资源不拦截
        registry.addInterceptor(new LoginInterceptor()).excludePathPatterns("/login/*")
                .excludePathPatterns("/css/**", "/fonts/**", "/images/**", "/js/**", "/lib/**");

        // 权限拦截
        registry.addInterceptor(new PermissionInterceptor()).excludePathPatterns("/login/*","/index","/welcome","/noPermission","/menu/*")
                .excludePathPatterns("/css/**","/fonts/**","/images/**","/js/**","/lib/**");
    }
}
