package com.example.pojo;

import java.util.Date;

/**
 * @Author: Cao
 * @Description: 评论
 * @Date: 2020/9/11
 **/
public class Discuss {
    private Integer id;
    //农产品id
    private Integer productId;
    //评论者id
    private Integer customerId;
    //评论内容
    private String commentContent;
    //评论状态
    private Integer commentStatus;
    //评论时间
    private Date commentTime;

    public Discuss(Integer id, Integer productId, Integer customerId, String commentContent, Integer commentStatus, Date commentTime) {
        this.id = id;
        this.productId = productId;
        this.customerId = customerId;
        this.commentContent = commentContent;
        this.commentStatus = commentStatus;
        this.commentTime = commentTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
}
