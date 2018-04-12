package com.crud.demo.Controller;

import com.crud.demo.Service.UserService;
import com.crud.demo.polo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String show(@RequestParam(value = "name")String userName){
        User user = userService.findByUserName(userName);
        if(null != user)
            return user.getUid()+"/"+user.getUserName()+"/"+user.getUserPhone();
        else return "null";
    }
}
