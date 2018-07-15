package com.liuchang.backend.login.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String getUser(){

        return "query user success";
    }
}
