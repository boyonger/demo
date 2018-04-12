package com.crud.demo.Dao;

import com.crud.demo.polo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer>{
    @Query("select u from User u where u.userName= ?1")
    User findByUserName(String name);
}

