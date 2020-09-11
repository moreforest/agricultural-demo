package com.example.controller.index;

import com.example.pojo.Admin;
import com.example.pojo.Menu;
import com.example.result.BuildResult;
import com.example.result.Result;
import com.example.service.index.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: Cao
 * @Description: 菜单权限
 * @Date: 2020/9/10
 **/
@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * 菜单列表显示
     *
     * @param httpSession
     * @return
     */
    @GetMapping("/menu/list")
    @ResponseBody
    public Result getMenu(HttpSession httpSession) {
        Admin admin = (Admin) httpSession.getAttribute("admin");
        List<Menu> menus = menuService.getMenuByAdmin(admin);
        return BuildResult.buildSuccess(menus);
    }

//     管理员管理 -- AdminController


    /**
     * 角色管理
     *
     * @param httpSession
     * @return
     */
    @GetMapping("/role/list")
    public String roleMenu(HttpSession httpSession) {
        return "/test";
    }

    /**
     * 权限数据管理
     *
     * @param httpSession
     * @return
     */
    @GetMapping("/permission/list")
    @ResponseBody
    public String permission(HttpSession httpSession) {
        return "ok";
    }
}
