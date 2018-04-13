package com.example.springbootdemo2.Controller;

import com.example.springbootdemo2.Pojo.User;
import com.example.springbootdemo2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index() {
        return "user/index";
    }

    @RequestMapping(value = "/show")
    @ResponseBody
    public String show(@RequestParam(value = "value") String value) {
        System.out.println(value);
        User user=null;
        //1表示增加user 2表示修改username 3表示删除user 4表示id获取user 5表示id列表获取userlist 6表示分页获取
        switch (Integer.parseInt(value)) {
            case 1:
                user = new User(new Date().getTime() + "", new Date().getTime() + "123");
                userService.save(user);
                System.out.println("success");
                break;
            case 2:
                int randomNum = (int) (Math.random() * 5);
                userService.updateUserNameByUid(randomNum, new Date().getTime() + "");
                System.out.println("success");
                break;
            case 3:
                userService.deleteUserByUId((int) (Math.random() * 5));
                System.out.println("success");
                break;
            case 4:
                return userService.findByUid((int) (Math.random() * 5))+"";
            /*case 5:
                List<Integer> list = new ArrayList<>();
                for (int i = 1; i < 6; i++) {
                    list.add(i);
                }
                return userService.findByUidList(list).toString();*/
            case 6:
                return userService.findByFirst10().toString(); //not success
            case 7:
                List<User> userList = new ArrayList<>();
                userList = userService.findAll();
                System.out.println(userList.toString());
                return userList.toString();
            case 8:
                user = userService.findByUserName("zhou");
                if (user!=null)
                    return user.toString();
                else return "null";
            default:
                return "null";
        }
        return "please see the console";
    }
}