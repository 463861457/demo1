package com.example.demo.controller;

import com.example.demo.config.ConfigGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("string")
public class DemoStringController11 {
    @Autowired
    @Qualifier( "configGet" )
    ConfigGet configGet;
//
////    @Resource(name="configGet")
////    ConfigGet configGet;
//
//
//    @RequestMapping("hello111")
//    public String toHello() {
//
//        return configGet.toString();
//    }


    @RequestMapping("helloli")
    public String toHell() {
        return "li5(";
    }



}
