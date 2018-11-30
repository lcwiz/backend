package com.liuchang.backend.global.common;

public class Result<T> {
    private String code;
    private String msg;
    private T data;
    private int count;


    public String getCode() {
        return code;
    }

    public Result<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public int getCount() {
        return count;
    }

    public Result setCount(int count) {
        this.count = count;
        return this;
    }
}
