package com.example.mapper.discuss;

import com.example.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: Cao
 * @Description:
 * @Date: 2020/9/11
 **/
@Mapper
public interface DiscussMapper {

    // 查询所有评论列表
    List<Admin> selectAllDiscuss(Map<String, Object> map);

    // 查询总记录数
    Long allCount();
}
