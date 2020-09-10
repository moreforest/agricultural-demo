package com.example.service.index;

import com.example.pojo.Admin;
import com.example.pojo.Menu;

import java.util.List;

/**
 * @Author: Cao
 * @Description:
 * @Date: 2020/9/9
 **/
public interface MenuService {
    //根据账户id获取该账户对应的id
    List<Menu> getMenuByAdmin(Admin admin);
}
