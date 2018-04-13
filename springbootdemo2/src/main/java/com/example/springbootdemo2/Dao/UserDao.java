package com.example.springbootdemo2.Dao;

import com.example.springbootdemo2.Pojo.User;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
    User findByUid(int uid);
    @Modifying
    @Query(value = "update User u set u.userName= :newUserName where u.uid = :uid")  //nativeQuery = true
    @Transactional
    void updateUserNameByUid(@Param("uid") int uid, @Param("newUserName") String newUserName);
}
