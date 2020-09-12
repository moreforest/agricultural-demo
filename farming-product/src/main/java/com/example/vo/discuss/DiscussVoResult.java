package com.example.vo.discuss;

import java.util.Date;

/**
 * @Author: Cao
 * @Description: 搜索 评论 显示
 * @Date: 2020/9/11
 **/
public class DiscussVoResult {
    private Integer id;
    private String commentContent;
    private Date commentTime;
    private Integer commentStatus;
    private String productName;
    private String username;

    public DiscussVoResult(Integer id, String commentContent, Date commentTime, Integer commentStatus, String productName, String username) {
        this.id = id;
        this.commentContent = commentContent;
        this.commentTime = commentTime;
        this.commentStatus = commentStatus;
        this.productName = productName;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
