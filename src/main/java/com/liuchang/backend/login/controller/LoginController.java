package com.liuchang.backend.login.controller;

import com.liuchang.backend.login.dto.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {

    @ApiOperation(value="")
    @RequestMapping(value="/user",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserList(){
        List<User> list =  new ArrayList<>();
        User user = new User();
        user.setGender("1");
        user.setUserid("u001");
        user.setUsername("刘畅");
        list.add(user);
        return list;
    }

    @RequestMapping(value = "/userinfo/{userId}",method = RequestMethod.GET)
    public String getUser( @PathVariable String userId){
        //@RequestParam(name = "userId",required = false)
        return "query user success to " + userId;
    }
}
