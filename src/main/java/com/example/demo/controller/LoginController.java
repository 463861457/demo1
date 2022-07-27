package com.example.demo.controller;

import com.example.demo.entity.LoginBean;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {
    @Resource
    private UserService userService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @RequestMapping(value = "/login")
//    public String login(Model model, String name, String pwd, HttpSession session) {//传loginBean含义是表示传入数据库中的一条数据，这条数据包含姓名和年龄
    public String login(Model model, LoginBean loginBean, HttpSession session) {//传loginBean含义是表示传入数据库中的一条数据，这条数据包含姓名和年龄
//        System.out.println(loginBean.toString());
//这个就相当于对用户输入的信息（账号和密码）进行一层加密。判断输入的信息是否符合要求，是在控制层加了一个判断语句boolean和if。
//        if (name.length() < 6 || pwd.length() < 6) {
//            model.addAttribute("msg", "用户名或密码长度过短");
//            return "index";
//        }

        LoginBean loginBean1 = new LoginBean();
        boolean exist = userService.login(loginBean);
        if (exist) {
            session.setAttribute("user", loginBean);
            model.addAttribute("name", loginBean.getName());
            System.out.println("验证一下1");
            return "success";
        }
        return "index";
    }

    @RequestMapping(value = "/query")  //用户认证  ； 参数校验 ；这是一种防护。
    public String query(Model model, HttpSession session) {
        Object user = session.getAttribute("user");
//        System.out.println("验证一下2");
        if (user == null) {
            System.out.println("请先登录");
            return "index";
        }
        model.addAttribute("user", user);
        return "query";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpSession session) {
        session.removeAttribute("user");
        return "index";
    }

    //参数校验（增加必填字段，格式校验）
//    public static void main(String args[]) {
//        String regex = "[1][34578][0-9]{9}"; //手机号码的格式：第一位只能为1，第二位可以是3，4，5，7，8，第三位到第十一位可以为0-9中任意一个数字
//        System.out.println("请输入11位手机号码");
//        Scanner s = new Scanner(System.in);  //System.in 表示获取控制台的信息；
//        String number = s.next();
//        if (number.matches(regex)) {
//            System.out.println("电话号码格式正确");
//        } else {
//            System.out.println("电话号码格式不正确");
//        }
//    }
}




