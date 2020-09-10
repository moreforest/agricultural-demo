package com.example.mapper.admin;

import com.example.pojo.Permissions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Cao
 * @Description:
 * @Date: 2020/9/9
 **/
@Mapper
public interface PermissionsMapper {

    // 通过id查询所有用户权限
    List<Permissions> queryAllPermissionByUser(Integer id);

    // 查询所有的权限
    List<Permissions> findAll();
}
