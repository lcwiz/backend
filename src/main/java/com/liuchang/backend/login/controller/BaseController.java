package com.liuchang.backend.login.controller;

import com.liuchang.backend.global.exception.MyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {
    @ExceptionHandler(value = { MyException.class })
        @ResponseBody
      protected String exception(Exception e,HttpServletRequest request) {
        return "报错信息统一集中于此";
    }

}
