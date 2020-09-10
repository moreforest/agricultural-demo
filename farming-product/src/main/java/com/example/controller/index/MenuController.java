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
 * @Description:
 * @Date: 2020/9/10
 **/
@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/menu/list")
    @ResponseBody
    public Result getMenu(HttpSession httpSession){
        Admin admin = (Admin) httpSession.getAttribute("admin");
        List<Menu> menus = menuService.getMenuByAdmin(admin);
        return BuildResult.buildSuccess(menus);
    }
}
