package com.huotu.entity;


import com.huotu.common.ResultType;

/**
 * Created by hxh on 2017-06-14.
 */
public class Result {
    private int code;
    private String msg;
    private Object data;

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result successWith(Object data) {
        return new Result(ResultType.ApiResult.SUCCESS.getCode(), ResultType.ApiResult.SUCCESS.getName(), data);
    }

    public static Result successWith() {
        return new Result(ResultType.ApiResult.SUCCESS.getCode(), ResultType.ApiResult.SUCCESS.getName(), null);
    }

    public static Result errorWith(ResultType.ApiResult apiResult) {
        return new Result(apiResult.getCode(), apiResult.getName(), null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
