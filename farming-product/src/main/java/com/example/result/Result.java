package com.example.result;

/**
 * @Author: Cao
 * @Description:
 * @Date: 2020/9/9
 **/
public class Result {
    // success 成功  fail 失败
    private String status;
    // 失败信息
    private String msg;
    // 错误的编号
    private Integer code;
    // 成功返回的数据
    private Object data;

    public Result() {
    }

    public Result(String status, String msg, Integer code, Object data) {
        this.status = status;
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
