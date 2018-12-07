package com.liuchang.backend.login.controller;

import com.liuchang.backend.global.exception.MyException;
import com.liuchang.backend.login.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController extends BaseController {
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
                          @RequestParam(name ="passwd",required = true)String passwd)
    throws Exception{
        System.out.println(username+"===="+passwd);
        if(1==1){
            throw new MyException();
        }
        return "/welcome.html";
    }


}
