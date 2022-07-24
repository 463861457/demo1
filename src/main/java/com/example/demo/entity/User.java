package com.example.demo.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2022-07-19 19:19:34
 */
public class User implements Serializable {
    private static final long serialVersionUID = -90796868546422021L;
    /**
     * 唯一的
     */
    private Integer id;
    /**
     * 姓名
     */
    private String username;
    /**
     * 年龄
     */
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

