package com.example.springbootdemo2.Service;

import com.example.springbootdemo2.Dao.UserDao;
import com.example.springbootdemo2.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public User findByUserName(String userName){
        User user=null;
        try{
            //System.out.println("2"+userName);
            user = userDao.findByUserName(userName);
        }catch (Exception e){
        }
        return user;
    }

    public List<User> findAll(){
       return userDao.findAll();
    }
}