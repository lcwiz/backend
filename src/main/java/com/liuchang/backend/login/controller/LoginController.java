package com.liuchang.backend.login.controller;

import com.liuchang.backend.login.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/users")
public class LoginController {
    @GetMapping
//    @ResponseBody
    public String getUser(){

        return "forward:/signin";
    }

    @GetMapping(value ="/users/{userid}")
    @ResponseBody
    public String getUserById(@PathVariable String userid)
    {

        return "receive search user id is " + userid;
    }

    @PostMapping(value = "/adduser")
    @ResponseBody
    public String insertUser(@RequestBody User user){
        System.out.println("=============="+user.getUserId());
        return "this userinfo insert successed";
    }
}
