package com.example.vo.index;

/**
 * @Author: Cao
 * @Description: 携带条件
 * @Date: 2020/9/8
 **/
public class AdminVo {

    private String username;
    private String password;
    private Integer status;

    public AdminVo() {
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
}
