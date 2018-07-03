package com.liuchang.backend.login.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping
public class LoginController {

    @RequestMapping("/users")
    public String authenticUser(String username){
        return "login sueccess";
    }
}
