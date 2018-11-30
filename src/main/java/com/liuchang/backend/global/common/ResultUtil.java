package com.liuchang.backend.global.common;

import java.util.List;

public class ResultUtil<T> {

    public Result successReturn(){
        Result<List> rslt = new Result<List>();
        rslt.setData(null);
        return  rslt;
    }

    public Result getSuccessResult(T data){
        return new Result()
                .setCode(String.valueOf(ResultEnum.SUCCESS.getRtnCode()))
                .setMsg(ResultEnum.SUCCESS.getRtnDesc(ResultEnum.SUCCESS.getRtnCode()))
                .setData(data);
    }

    public Result getFailResult(){
        return new Result()
                .setCode(String.valueOf(ResultEnum.FAIL.getRtnCode()))
                .setMsg(ResultEnum.FAIL.getRtnDesc(ResultEnum.FAIL.getRtnCode()))
                .setData(null);
    }
}
