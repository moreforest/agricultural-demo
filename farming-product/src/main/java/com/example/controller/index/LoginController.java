package com.example.controller.index;

import com.example.exception.CustomerException;
import com.example.pojo.Admin;
import com.example.result.BuildResult;
import com.example.result.Result;
import com.example.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author: Cao
 * @Description: 登录界面
 * @Date: 2020/9/9
 **/
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/loginPage")
    public String loginPage() {
        return "/login";
    }

    /**
     * 用户登录验证
     *
     * @return
     */
    @PostMapping("/loginIn")
    @ResponseBody
    public Result loginIn(String username, String password, HttpSession httpSession) {
        if (StringUtils.isEmpty(username)) {
            System.out.println("111");
            return BuildResult.buildFail("用户名不能为空", 500);
        }
        if (StringUtils.isEmpty(password)) {
            System.out.println("222");
            return BuildResult.buildFail("密码不能为空", 500);
        }

        try {
            Admin admin = adminService.loginIn(username, password);
            httpSession.setAttribute("admin", admin);
            return BuildResult.buildSuccess(admin.getUsername());
        } catch (CustomerException e) {
            return BuildResult.buildFail(e.getMessage(), 50003);
        }

    }


}
