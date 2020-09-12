package com.example.vo.discuss;

/**
 * @Author: Cao
 * @Description:
 * @Date: 2020/9/8
 **/
public class DiscussVo {
    // 农产品名
    private String product;
    // 评论者姓名
    private String diss;
    // 评论内容
    private String comment;
    // 评论状态
    private Integer status;

    public DiscussVo(String product, String diss, String comment, Integer status) {
        this.product = product;
        this.diss = diss;
        this.comment = comment;
        this.status = status;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDiss() {
        return diss;
    }

    public void setDiss(String diss) {
        this.diss = diss;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
