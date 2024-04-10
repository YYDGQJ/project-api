package com.project.common.response;

import lombok.Data;

/**
 * ResultBean
 * @author YYDGQJ
 */
@Data
public class ResultBean<T> {
    private Integer code;

    private String msg;

    private T data;

    public ResultBean<T> success(String msg){
        this.code = 1;
        this.msg = msg;
        return this;
    }

    public ResultBean<T> success(T t){
        this.code = 1;
        this.setData(t);
        return this;
    }

    public static <T> ResultBean<T> ok() {
        ResultBean<T> r = new ResultBean<T>();
        r.setCode(1);
        r.setMsg("成功");
        return r;
    }

    public static <T> ResultBean<T> ok(String msg) {
        ResultBean<T> r = new ResultBean<T>();
        r.setCode(1);
        r.setMsg(msg);
        return r;
    }

    public ResultBean<T> error500(String msg) {
        this.msg = msg;
        this.code = 0;
        return this;
    }

    public static<T> ResultBean<T> error(String msg) {
        ResultBean<T> r = new ResultBean<T>();
        r.setCode(0);
        r.setMsg(msg);
        return r;
    }

    public static <T> ResultBean<T> error(int code, String msg) {
        ResultBean<T> r = new ResultBean<T>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }
}
