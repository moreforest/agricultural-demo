package com.example.result;

/**
 * @Author: Cao
 * @Description: 前端返回数据结果类
 * @Date: 2020/9/9
 **/
public class BuildResult {
    /**
     * 失败
     *
     * @param msg
     * @param code
     * @return
     */
    public static Result buildFail(String msg, Integer code) {
        return new Result("fail", msg, code, null);
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static Result buildSuccess(Object data) {
        return new Result("success", null, null, data);
    }
}
