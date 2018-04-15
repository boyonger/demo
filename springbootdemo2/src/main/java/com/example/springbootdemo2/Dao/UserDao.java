package com.example.springbootdemo2.Dao;

import com.example.springbootdemo2.Pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserDao{

    @Insert("Insert Into user_table(user_name,user_phone) value(#{userName},#{userPhone})")
    void inserUser(User user);

    @Update("update user_table set user_name=#{userName} where uid=#{uid}")
    void updateUserNameByUid(@Param("userName") String userName,@Param("uid") int uid);

    @Delete("delete from user_table where uid=#{uid}")
    void deleteByUid(int uid);

    @Select("SELECT * from user_table WHERE uid=#{uid}")
    @Results(id="reflectToUser",value={
            @Result(property = "userName" ,column="user_name"),
            @Result(property = "userPhone",column = "user_phone")
    })
    User findByUid(String uid);

    @Select("SELECT * from user_table WHERE uid in (${uidList})")
    @ResultMap("reflectToUser")
    List<User> findByUidList(@Param("uidList")String uidList);

    @Select("SELECT * FROM user_table LIMIT ${pageBegin},${pageSize}")
    @ResultMap("reflectToUser")
    List<User> findByPage(@Param("pageBegin") String pageBegin,@Param("pageSize") String pageSize);

    @Select("SELECT * FROM user_table WHERE user_name=#{userName} OR user_phone=#{userPhone}")
    @ResultMap("reflectToUser")
    List<User> findByUserNameOrPhone(@Param("userName") String userName,@Param("userPhone") String userPhone);
}
