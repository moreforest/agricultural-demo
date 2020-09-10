package com.example.pojo;

import java.util.Date;

/**
 * @Author: Cao
 * @Description:
 * @Date: 2020/9/7
 **/
public class Admin {
    private Integer id;
    private String username;
    private String password;
    // 状态 1正常 0禁用
    private Integer status;
    private Date created;
    private Date lastLoginTime;
    // 删除状态 1删除 0未删除
    private Integer isDeleted;

    public Admin(Integer id) {
        this.id = id;
    }

    public Admin() {
    }

    public Admin(Integer id, String username, String password, Integer status, Date created, Date lastLoginTime, Integer isDeleted) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.created = created;
        this.lastLoginTime = lastLoginTime;
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
