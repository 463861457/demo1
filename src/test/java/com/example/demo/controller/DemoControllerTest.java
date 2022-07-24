package com.example.demo.controller;

import com.example.demo.entity.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import javax.swing.tree.TreePath;
import java.sql.ClientInfoStatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
//@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest
@EnableAutoConfiguration
class DemoControllerTest {

    @Autowired
    DemoStringController demoStringController;

    @Test
    void toHello() {
        System.out.println(demoStringController.toHello());
    }


    //    @Test
//    void toHello() {
//    }
    //数据源组件
    @Autowired
    DataSource dataSource;
    //用于访问数据库的组件
    @Autowired
    JdbcTemplate jdbcTemplate;

//    @Test
//    void contextLoads() throws SQLException {
//         1.验证访问数据库是否成功
//        System.out.println("默认数据源为：" + dataSource.getClass());
//        System.out.println("数据库连接实例：" + dataSource.getConnection());
//        //访问数据库
//        Integer i = jdbcTemplate.queryForObject("SELECT count(*) from `book`", Integer.class);
//        System.out.println("user 表中共有" + i + "条数据。");//此处sout的作用是验证数据库的连接是否成功；

    // 2. 验证是否能够成功打印出数据库中指定的数据
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select *from book");
//        //每一条数据打印出来
//        System.out.println(maps.get(0));
//        for (int i = 0; i < maps.size(); i++) {  //这种循环，有索引。
//            Map<String, Object> x = maps.get(i);
//            System.out.println(x);
//        }
//        for (Map<String, Object> map : maps) {   //这种循环索引
//            System.out.println(map);
//        }


    @Test
    void contextLoads() throws SQLException {
//        RowMapper rowMapper = new RowMapper() {
//            @Override
//            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
//                return null;
//            }
//        };

        //用Book对象去接数据库，相当于直接操作数据库
        List<Book> list = jdbcTemplate.query("select *from book", new BeanPropertyRowMapper<>(Book.class));
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }


          //for i 循环与下面的for()循环一样的作用
        for (Book book : list) {    //此循环是java 8 新版本的特性
            System.out.println(book);
        }
    }
}