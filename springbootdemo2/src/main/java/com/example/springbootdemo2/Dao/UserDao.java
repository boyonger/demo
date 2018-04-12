package com.example.springbootdemo2.Dao;

import com.example.springbootdemo2.Pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer>{
    @Query("select u from User u where u.userName = :userName")
    User findByUserName(@Param("userName") String userName);
}
