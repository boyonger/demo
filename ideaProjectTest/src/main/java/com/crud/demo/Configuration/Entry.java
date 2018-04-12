package com.crud.demo.Configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.crud.demo")
public class Entry {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Entry.class, args);
    }
}

/*
    USE test;
    CREATE TABLE user_table(
        uid INT UNSIGNED NOT NULL AUTO_INCREMENT,
        user_name VARCHAR(32) NOT NULL ,
    user_phone VARCHAR(32) NOT NULL,
    PRIMARY KEY(uid)
	);*/
