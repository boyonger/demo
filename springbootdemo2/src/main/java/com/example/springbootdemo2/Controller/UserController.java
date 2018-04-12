package com.example.springbootdemo2.Controller;

import com.example.springbootdemo2.Pojo.User;
import com.example.springbootdemo2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index(){
        return "user/index";
    }

    @RequestMapping(value = "/show")
    @ResponseBody
    public String show(@RequestParam(value = "userName")String userName){
        System.out.println(userName);
        User user = userService.findByUserName(userName);
        List<User> list=new ArrayList<>();
        list=userService.findAll();
        System.out.println(list.toString());
        if(null != user)
            return user.getUid()+"/"+user.getUserName()+"/"+user.getUserPhone();
        else return "null";
    }
}