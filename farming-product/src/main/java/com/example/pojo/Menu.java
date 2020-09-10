package com.example.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxd on 2020-09-09
 */
public class Menu {
    /**
     * 菜单ID=>权限ID
     */
    private Integer menuId;
    /**
     * 菜单的名字=> 权限的名字
     */
    private String menuName;
    /**
     * 菜单的url=> 权限url
     */
    private String menuUrl;
    /**
     * 菜单的父级ID=> 权限的父级ID
     */
    private Integer menuParentId;
    /**
     * 子级菜单
     */
    private List<Menu> subMenu = new ArrayList<>();

    public Menu() {
    }

    public Menu(Integer menuId, String menuName, String menuUrl, Integer menuParentId) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.menuParentId = menuParentId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    public List<Menu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<Menu> subMenu) {
        this.subMenu = subMenu;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuParentId=" + menuParentId +
                ", subMenu=" + subMenu +
                '}';
    }
}
