package com.example.mapper.discuss;

import com.example.pojo.Discuss;
import com.example.vo.discuss.DiscussVo;
import com.example.vo.discuss.DiscussVoResult;
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
    List<DiscussVoResult> selectAllDiscuss(Map<String, Object> map);

    // 查询总记录数
    Long allCount(DiscussVo discussVo);

    // 拉黑评论
    Integer blackDiscuss(Map<String, Object> map);

    // 删除评论
    Integer delDiscuss(Integer id);

    //    ---------------------------用户操作--------------------
//    用户新增评论
    Integer insertDiscuss(Discuss discuss);

}
