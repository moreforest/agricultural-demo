package com.example.vo.index;

/**
 * @Author: Cao
 * @Description: 分页
 * @Date: 2020/9/9
 **/
public class QueryInfo {
    // 当前页数
    private Integer page;
    // 分页大小
    private Integer pageSize;

    // 计算开始序号
    private Integer startIndex;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    // 计算开始序号
    public Integer getStartIndex() {
        this.startIndex = (this.page - 1) * this.pageSize;
        return startIndex;
    }
}
