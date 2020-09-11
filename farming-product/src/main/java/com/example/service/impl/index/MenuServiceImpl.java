package com.example.service.impl.index;

import com.example.mapper.admin.PermissionsMapper;
import com.example.pojo.Admin;
import com.example.pojo.Menu;
import com.example.pojo.Permissions;
import com.example.service.index.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cao
 * @Description: 菜单权限
 * @Date: 2020/9/9
 **/
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    PermissionsMapper permissionsMapper;

    @Override
    public List<Menu> getMenuByAdmin(Admin admin) {

        List<Permissions> permissions = new ArrayList<>();

        // 1.如果是超级管理员，查询所有权限
        if ("admin".equals(admin.getUsername())) {
            permissions = permissionsMapper.findAll();
//            System.out.println("超级管理员" + permissions.size());
        } else {
            // 2.不是超级管理员，查询其对应权限
            permissions = permissionsMapper.queryAllPermissionByUser(admin.getId());
//            System.out.println("不是超级管理员" + permissions.size());
        }

        //3. 查找所有的一级权限
        List<Menu> menus = new ArrayList<>();

        for (Permissions p : permissions) {
            if (p.getIsMenu() == 0) {
                continue; // 不是菜单权限
            }
            if (p.getParentId() != 0) {
                // 父级id不是0 则不是一级权限
                continue;
            }
            // 将一级权限放在集合中
            menus.add(new Menu(p.getId(), p.getPermissionName(), p.getPermissionUrl(), p.getParentId()));
        }

        //查找一级菜单权限的二级菜单权限
        for (Menu m : menus) {  //遍历一级菜单权限
            //查找每一个一级菜单权限的二级菜单权限
            for (Permissions p : permissions) {
                if (p.getIsMenu() == 0) {
                    continue; // 不是菜单权限
                }

                //如果不是二级菜单直接进入下次循环
                if (p.getPermissionLevel() != 2) {
                    continue;
                }

                //二级菜单权限    判断当前遍历的权限是否是一级菜单权限的子权限
                if (p.getParentId() == m.getMenuId()) {
                    // 添加对应子权限
                    Menu child = new Menu(p.getId(), p.getPermissionName(), p.getPermissionUrl(), p.getParentId());
                    m.getSubMenu().add(child);
//                    System.out.println(m.getMenuName() + "子菜单" + child.getMenuName());
                }
            }
        }
        return menus;
    }
}
