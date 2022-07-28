package com.example.demo.config;

import com.sun.istack.internal.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

//AOP  统一拦截统一处理

//申明是个切面
@Aspect  //开始切面   切点编程
//申明是个spring管理的bean
@Configuration
@Order(1)
public class LogDeal {

    private Logger log = Logger.getLogger(LogDeal.class);  //Logger有好几种，要分清哪一种类型，才能使用，不报错

    @Pointcut("execution(* com.example.demo.controller.*.*(..))")   //切点的地址要记清，差一个点都报错，     定义一个切点（统一拦截哪里）
    private void controllerAspect() {
    }

    //通过方法controllerAspect，实现拦截之后具体的操作
    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //打印请求内容
        log.info("===============请求内容===============");
        log.info("请求地址:" + request.getRequestURL().toString());
        log.info("请求方式:" + request.getMethod());
        log.info("请求类方法:" + joinPoint.getSignature());
        log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        log.info("===============请求内容===============");
    }

    //在方法执行完结后打印返回内容
    @AfterReturning(returning = "o", pointcut = "controllerAspect()")
    public void methodAfterReturing(Object o) {
        log.info("--------------返回内容----------------");

        log.info("--------------返回内容----------------");
    }
}
