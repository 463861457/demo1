package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication   //表示SpringBoot启动类
@MapperScan("com.example.demo.dao*")   //统一配置，扫描这个路径下的所有类。  *表示匹配
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
