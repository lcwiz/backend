package com.liuchang.backend.global;

public enum ResultCode {

    SUCCESS(200,"成功返回"),
    FAILED(404,"资源访问失败");

    private Integer rtnCode;

    private String rtnName;

    ResultCode(int rtnCode, String rtnName) {
        this.rtnCode = rtnCode;
        this.rtnName = rtnName;
    }
}
