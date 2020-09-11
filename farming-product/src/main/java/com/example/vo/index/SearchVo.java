package com.example.vo.index;

import java.util.Date;

/**
 * @Author: Cao
 * @Description: 管理员列表 -- 搜索功能
 * @Date: 2020/9/11
 **/
public class SearchVo {
    // 创建时间
    private Date start;
    // 最后登录时间
    private Date end;
    // 用户名
    private String searchname;

    public SearchVo(Date start, Date end, String searchname) {
        this.start = start;
        this.end = end;
        this.searchname = searchname;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getSearchname() {
        return searchname;
    }

    public void setSearchname(String searchname) {
        this.searchname = searchname;
    }
}
