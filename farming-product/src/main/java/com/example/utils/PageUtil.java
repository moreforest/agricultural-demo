package com.example.utils;

import java.util.ArrayList;
import java.util.List;

public class PageUtil<T> {

    //当前页
    private Integer nowPage = 1;

    //每页多少条记录
    private Integer pageSize = 5;

    //总页数
    private Integer totalPages;


    //分页数
    private List<Integer> pagesList = new ArrayList<>();

    //总记录数
    private Long totalNums = 0L;

    //上一页
    private Integer prevPage;

    //下一页
    private Integer nextPage;

    //第一页
    private Integer firstPage = 1;

    //最后一页
    private Integer lastPage;

    //每一页内容
    private List<T> content;

    public Integer getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(Integer prevPage) {
        this.prevPage = prevPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public List<Integer> getPagesList() {
        return pagesList;
    }

    public void setPagesList(List<Integer> pagesList) {
        this.pagesList = pagesList;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public Long getTotalNums() {
        return totalNums;

    }

    public void setTotalNums(Long totalNums) {
        this.totalNums = totalNums;
        setAttributeOther();
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    private void setAttributeOther() {
        this.totalPages = (int) Math.ceil(this.totalNums / (this.pageSize + 0.0));
        this.prevPage = this.nowPage - 1 <= 0 ? 1 : this.nowPage - 1;
        this.nextPage = this.nowPage + 1 > this.totalPages ? this.nowPage : this.nowPage + 1;
        this.lastPage = this.totalPages;
        for (int i = 1; i <= this.totalPages; i++) {
            pagesList.add(i);
        }
    }
}
