package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController    //返回的是当前的东西，是什么就是什么
//@RequestMapping("/string")
//@RequestMapping("/string/")     //请求路径这里，加几个斜杠都可以成功访问。一般是不加；
@RequestMapping("/string/")
public class DemoStringController {

    @Value("${aaa.bbb}")    //这个地方是大括号，不是小括号
    private String ss;

    @Value("${aaa.ccc}")
    private String ss1;

    @Value("${aaa.ddd:110}")    //加一个冒号并有数值，防止获取不到配置文件的数值报错情况，取不到配置文件数值，那么输出的就是110
    private String ss2;

    @RequestMapping("hello")
    public Object toHello() {
        //调用了模型层
        return ss;

//        return "ss";
//        return "hello";
    }

//    @RequestMapping("/hello2")
//    public String toHello2() {
//        return "hello";
//    }

}
