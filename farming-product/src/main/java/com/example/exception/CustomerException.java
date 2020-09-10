package com.example.exception;

/**
 * @Author: Cao
 * @Description: 自定义异常
 * @Date: 2020/9/8
 **/
public class CustomerException extends Exception {
    // 异常信息
    private String message;

    public CustomerException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
