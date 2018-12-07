package com.liuchang.backend.global.exception;

import com.liuchang.backend.global.common.Result;
import com.liuchang.backend.global.common.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    public Result handler(Exception e){
        return new ResultUtil().getSuccessResult(e.getMessage());
    }
}
