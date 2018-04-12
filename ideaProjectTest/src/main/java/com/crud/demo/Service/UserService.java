package com.crud.demo.Service;

import com.crud.demo.Dao.UserDao;
import com.crud.demo.polo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public User findByUserName(String userName){
        User user=null;
        try{
            user = userDao.findByUserName(userName);
        }catch (Exception e){
        }
        return user;
    }
}
