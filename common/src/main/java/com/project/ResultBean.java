package com.project;

import lombok.Data;

/**
 * ResultBean
 *
 * @author YYDGQJ
 * 创建日期  2026/4/14 10:35
 * 描述
 *
 */
@Data
public class ResultBean<T> {
    private Integer doFlag;
    private String msg;
    private T data;

    // 成功状态的通用设置方法
    private ResultBean<T> setSuccess(int doFlag, String msg, T data) {
        this.doFlag = doFlag;
        this.msg = msg;
        this.data = data;
        return this;
    }

    // 错误状态的通用设置方法
    private ResultBean<T> setError(int doFlag, String msg) {
        this.doFlag = doFlag;
        this.msg = msg;
        return this;
    }

    // 成功并返回自身实例，可根据需要设置消息和数据
    public ResultBean<T> success(String msg) {
        return setSuccess(0, msg, null);
    }

    public ResultBean<T> success(Integer doFlag, String msg) {
        return setSuccess(doFlag, msg, null);
    }

    public ResultBean<T> success(T t) {
        return setSuccess(0, null, t);
    }

    public ResultBean<T> success(Integer doFlag, T t) {
        return setSuccess(doFlag, null, t);
    }

    public ResultBean<T> success(String msg, T t) {
        return setSuccess(0, msg, t);
    }

    public ResultBean<T> success(Integer doFlag, String msg, T t) {
        return setSuccess(doFlag, msg, t);
    }

    // 静态方法创建成功的ResultBean实例，可根据需要设置消息和数据
    public static <T> ResultBean<T> ok() {
        return new ResultBean<T>().setSuccess(0, "成功", null);
    }

    public static <T> ResultBean<T> ok(String msg) {
        return new ResultBean<T>().setSuccess(0, msg, null);
    }

    public static <T> ResultBean<T> ok(Integer doFlag, String msg) {
        return new ResultBean<T>().setSuccess(doFlag, msg, null);
    }

    public static <T> ResultBean<T> ok(T t) {
        return new ResultBean<T>().setSuccess(0, null, t);
    }

    public static <T> ResultBean<T> ok(Integer doFlag, T t) {
        return new ResultBean<T>().setSuccess(doFlag, null, t);
    }

    public static <T> ResultBean<T> ok(Integer doFlag, T t, String msg) {
        return new ResultBean<T>().setSuccess(doFlag, msg, t);
    }


    // 错误并返回自身实例，可根据需要设置错误码和消息
    public ResultBean<T> error500(String msg) {
        return setError(-1, msg);
    }

    public ResultBean<T> error500(Integer doFlag, String msg) {
        return setError(doFlag, msg);
    }

    // 静态方法创建错误的ResultBean实例，可根据需要设置错误码和消息
    public static <T> ResultBean<T> error(String msg) {
        return new ResultBean<T>().setError(-1, msg);
    }

    public static <T> ResultBean<T> error(int code, String msg) {
        return new ResultBean<T>().setError(code, msg);
    }
}
