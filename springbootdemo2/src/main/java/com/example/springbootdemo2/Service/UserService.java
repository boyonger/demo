package com.example.springbootdemo2.Service;

import com.example.springbootdemo2.Dao.UserDao;
import com.example.springbootdemo2.Pojo.User;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
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

    @Transactional
    public void save(User user){
        userDao.save(user);
    }

    public void updateUserNameByUid(int uid,String newUserName){
        userDao.updateUserNameByUid(uid,newUserName);
    }

    public void deleteUserByUId(int uid){
        userDao.deleteById(uid);
    }

    public User findByUid(int uid){
       return  userDao.findByUid(uid);
    }

  /*  public List<User> findByUidList(List<Integer> userList){
        Iterable<ID> iterable=new ArrayList<>();
        return userDao.findAll();
    }*/

    public List<User> findByFirst10(){
        Sort sort = new Sort(Sort.Direction.DESC, "uid");
        Pageable pageable =new PageRequest(3,3,sort);
        return userDao.findAll(pageable).getContent();
    }
}