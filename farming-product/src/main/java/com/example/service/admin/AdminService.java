package com.example.service.admin;

import com.example.exception.CustomerException;
import com.example.pojo.Admin;
import com.example.result.Result;
import com.example.utils.PageUtil;
import com.example.vo.index.QueryInfo;
import com.example.vo.index.SearchVo;

/**
 * @Author: Cao
 * @Description:
 * @Date: 2020/9/7
 **/
public interface AdminService {

    String insertAdmin(Admin admin);

    //添加管理员账户
    Result addAdmin(Admin admin) throws CustomerException;

    // 登录
    Admin loginIn(String username, String password) throws CustomerException;

    // 查询所有用户
//    PageUtil<Admin> selectAllAdmin(QueryInfo queryInfo);
    PageUtil<Admin> selectAllAdmin(QueryInfo queryInfo, SearchVo searchVo);

    // 通过id查询用户
    Admin findAdminById(Integer id);

    // 修改管理员账户
    Result editAdmin(Admin admin) throws CustomerException;

    // 通过id删除管理员账号
    Result delAdminById(Integer[] data) throws CustomerException;


}
