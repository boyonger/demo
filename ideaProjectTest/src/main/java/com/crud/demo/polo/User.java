package com.crud.demo.polo;

import javax.persistence.*;

@Entity
@Table(name="user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    @Column(name="user_name",nullable = false)
    private String userName;
    @Column(name="user_phone",nullable = false)
    private String userPhone;

    public User(String userName, String userPhone) {
        this.userName = userName;
        this.userPhone = userPhone;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }


}
