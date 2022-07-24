package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller  //是控制器
@RequestMapping("/test/")
public class DemoController {
    @Autowired
    JdbcTemplate jdbcTemplate;

//    @Autowired
//    BookService bookService;

    @RequestMapping("hello")
    public String toHello(Model model, HttpServletRequest request) {
//        List<Map<String, Object>> maps = bookService.selectDtata();
//        model.addAttribute("list", maps);
////        model.addAttribute("heihei", maps.get(7));
        return "login0";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String toHello(Model model) {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select *from book");
        //每一条数据打印出来
        model.addAttribute("list", maps);  //Attribute属性；    这一步的作用是往集合里面放参数；
//        model.addAttribute("list",maps.get(7));
       Object list1 = model.getAttribute("list");      //这一步的作用是从集合里面拿参数list；
        List<Map<String, Object>> list = (List<Map<String, Object>>) model.getAttribute("list");
        //调用了模型层
        return"six";
}

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
////    @RequestMapping("hello2")
//    public String toHello2() {
//        return "hello";
//    }
////
//
//    @RequestMapping("hello3")
//    @ResponseBody       //指定toHello3方法，返回数据；
//    public String toHello3() {
//        return "hello";
//    }

}
