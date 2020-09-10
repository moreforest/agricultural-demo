package com.example.exception;

import com.example.result.BuildResult;
import com.example.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Cao
 * @Description: 异常拦截器
 * @Date: 2020/9/9
 **/
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 未知异常
     *
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exception(Exception e) {
        e.printStackTrace();
        return BuildResult.buildFail("对不起，系统出小差了。。", 5000);
    }

    /**
     * 自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(CustomerException.class)
    @ResponseBody
    public Result myException(CustomerException e) {
        return BuildResult.buildFail(e.getMessage(), 5000);
    }
}
