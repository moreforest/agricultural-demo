package com.example.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Cao
 * @Description:
 * @Date: 2020/9/8
 **/
@Controller
public class IndexController {

    /**
     * 跳转到首页index
     *
     * @return
     */
    // 虚拟的映射路径
    @RequestMapping("/index")
    public String index() {
        //如果方法的返回值类型 用的String，代表转发到指定名称的模板页面
        return "/index";
    }

    /**
     * 跳转到 欢迎界面
     *
     * @return
     */
    @RequestMapping("/welcome")
    public String welcome() {
        return "/welcome";
    }

    /**
     * 无权限访问
     *
     * @return
     */
    @RequestMapping("/noPermission")
    public String noPermission() {
        return "/noPermission";
    }
}
