package com.example.service.discuss;

import com.example.exception.CustomerException;
import com.example.pojo.Admin;
import com.example.pojo.Discuss;
import com.example.result.Result;
import com.example.utils.PageUtil;
import com.example.vo.discuss.DiscussVo;
import com.example.vo.discuss.DiscussVoResult;
import com.example.vo.index.QueryInfo;

/**
 * @Author: Cao
 * @Description:
 * @Date: 2020/9/8
 **/
public interface DiscussService {

    //    ---------------------------管理员操作--------------------
    // 查询所有评论列表
    PageUtil<DiscussVoResult> selectAllDiscuss(QueryInfo queryInfo, DiscussVo discussVo);

    // 拉黑评论
    Result blackDiscuss(Integer id, Integer status) throws CustomerException;

    // 删除评论
    Result delDiscuss(Integer id) throws CustomerException;


    //    ---------------------------用户操作--------------------
    //    用户新增评论
    Result insertDiscuss(Discuss discuss) throws CustomerException;
}
