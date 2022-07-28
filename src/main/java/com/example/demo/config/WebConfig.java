package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//表明这是配置类，并交给Spring管理
public class WebConfig implements WebMvcConfigurer {   //WebMvcConfigurer    mvc的配置

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**")//设置拦截路径；/**表示所有都拦截
                .excludePathPatterns("/index/**","/login");// 哪些路径不拦截（如果登录路径都拦截了用户还干什么啊），所以登录页面不能拦截
    }

    @Bean    //注入当前的拦截器
    public MyInterceptor loginInterceptor(){
        return new MyInterceptor();
    }
}