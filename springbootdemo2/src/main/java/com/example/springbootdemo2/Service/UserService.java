package com.example.springbootdemo2.Service;

import com.example.springbootdemo2.Dao.UserDao;
import com.example.springbootdemo2.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public Boolean insertUser(User user) {
        if (userDao.findByUserNameOrPhone(user.getUserName(),user.getUserPhone()).size()>0)
            return false;
        else {
            userDao.inserUser(user);
            return true;
        }
    }

    public void updateUserNameByUid(String userName, int uid) {
        userDao.updateUserNameByUid(userName, uid);
    }

    /*  public List<User> findByUidList(List<Integer> userList){
          Iterable<ID> iterable=new ArrayList<>();
          return userDao.findAll();
      }*/
    public void deleteUserByUid(int uid) {
        userDao.deleteByUid(uid);
    }

    public User findByUid(String uid) {
        User user= userDao.findByUid(uid);
        System.out.println(user.getUserPhone());
        return user;
    }

    public List<User> findByUidList(String uidList) {

        return userDao.findByUidList(uidList);
    }

    public List<User> findByPage(String pageBegin,String pageSize){
        return userDao.findByPage(pageBegin,pageSize);
    }


}