package com.example.service.discuss;

import com.example.pojo.Admin;
import com.example.utils.PageUtil;
import com.example.vo.index.QueryInfo;
import com.example.vo.index.SearchVo;

/**
 * @Author: Cao
 * @Description:
 * @Date: 2020/9/8
 **/
public interface DiscussService {
    // 查询所有评论列表
    PageUtil<Admin> selectAllDiscuss(QueryInfo queryInfo, SearchVo searchVo);
}
