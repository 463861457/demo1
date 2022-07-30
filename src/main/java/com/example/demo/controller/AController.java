package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/abc")
    public Object abc() {
        //访问数据库
        Integer i = jdbcTemplate.queryForObject("SELECT count(*) from `book`", Integer.class);
        System.out.println("user 表中共有" + i + "条数据。");
        return i;
        //此处sout的作用是验证数据库的连接是否成功；此处return的作用也是验证数据库的连接是否成功，但是要去网页上验证。
//        111111111111111111
    }
}
