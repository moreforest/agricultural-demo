package com.example.controller.admin;

import com.example.pojo.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Cao
 * @Description:
 * @Date: 2020/9/12
 **/
@Controller
@RequestMapping("/role")
public class RoleController {
    /**
     * 跳转到角色管理页面
     *
     * @return
     */
    @RequestMapping("/list")
    public String editPage(Integer id, Model model) {
//        Admin admin = adminService.findAdminById(id);
//        model.addAttribute("admin", admin);
        return "/admin/role-list";
    }
}
