package com.liuchang.backend.login.controller;

import com.liuchang.backend.login.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("signin.html");
        return mv;
    }

    @RequestMapping("/welcome")
    public String loginSuccess(){
        return "/welcome.html";
    }

    @GetMapping(value ="/users/{userid}")
    @ResponseBody
    public String getUserById(@PathVariable String userid)
    {
        return "receive search user id is " + userid;
    }


    @RequestMapping(value="/adduser",method = RequestMethod.POST)
    @ResponseBody
    public User insertUser( @RequestBody User user){
        return user;
    }

    @RequestMapping(value = "/toLogin" ,method = RequestMethod.GET)
    public String toLogin(@RequestParam(name = "username",required = true)String username,
                          @RequestParam(name ="passwd",required = true)String passwd){
        System.out.println(username+"===="+passwd);
        return "/welcome.html";
    }
}
