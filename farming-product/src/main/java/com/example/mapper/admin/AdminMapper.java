package com.example.mapper.admin;

import com.example.pojo.Admin;
import com.example.vo.index.AdminVo;
import com.example.vo.index.QueryInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Cao
 * @Description:
 * @Date: 2020/9/7
 **/
@Mapper
public interface AdminMapper {
    // 添加数据
    void addAdmin(Admin admin);

    // 查询所有管理员
    List<Admin> selectAllAdmin(QueryInfo queryInfo);

    // 查询总记录数
    Long allCount();

    // 根据用户名查询一个用户
    // 根据用户名和密码查询一个用户
    // 查询没有禁用的账户
    List<Admin> queryAdminByWhere(AdminVo adminVo);

    // 根据id查询用户
    Admin findAdminById(Long id);

    // 根据id删除管理员
    Integer delAdminById(Long id);

    /**
     * 修改 password status lastLoginTime
     * @param admin
     */
    void updateAdmin(Admin admin);
}
