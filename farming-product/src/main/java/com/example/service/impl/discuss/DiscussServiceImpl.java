package com.example.service.impl.discuss;

import com.example.mapper.discuss.DiscussMapper;
import com.example.pojo.Admin;
import com.example.service.discuss.DiscussService;
import com.example.utils.PageUtil;
import com.example.vo.index.QueryInfo;
import com.example.vo.index.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Cao
 * @Description:
 * @Date: 2020/9/8
 **/
@Service
public class DiscussServiceImpl implements DiscussService {

    @Autowired
    DiscussMapper discussMapper;

    @Override
    public PageUtil<Admin> selectAllDiscuss(QueryInfo queryInfo, SearchVo searchVo) {
        // 查询所有管理员 -- 分页
        Map<String, Object> map = new HashMap<>();
        map.put("searchname", searchVo.getSearchname());
        map.put("start", searchVo.getStart());
        map.put("end", searchVo.getEnd());
        map.put("startIndex", queryInfo.getStartIndex());
        map.put("pageSize", queryInfo.getPageSize());
        //1.根据开始序号和分页大小查询页面需要显示数据
        List<Admin> adminList = discussMapper.selectAllDiscuss(map);
        System.out.println(adminList.size());
        //2.查询总记录数
        Long count = discussMapper.allCount();
        System.out.println(count);

        PageUtil<Admin> pageUtil = new PageUtil<>();
        pageUtil.setContent(adminList);
        pageUtil.setTotalNums(count);
        pageUtil.setNowPage(queryInfo.getPage());
        pageUtil.setPageSize(queryInfo.getPageSize());

        System.out.println(pageUtil.getContent().size());

        return pageUtil;
    }
}
