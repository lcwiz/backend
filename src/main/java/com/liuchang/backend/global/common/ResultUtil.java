package com.liuchang.backend.global.common;

import java.util.List;

public class ResultUtil {

    public Result successReturn(){
        Result<List> rslt = new Result<List>();
        rslt.setData(null);
        return  rslt;
    }

    public Result getSuccessResult(){
        return new Result()
                .setCode(String.valueOf(ResultEnum.SUCCESS.getRtnCode()))
                .setMsg(ResultEnum.SUCCESS.getName(ResultEnum.SUCCESS.getRtnCode()))
                .setData(null);
    }
}
