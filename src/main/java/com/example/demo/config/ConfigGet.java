package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "aaa")
public class ConfigGet {    //一个类里面有3个属性

    private String bbb;
    private String ccc;
    private String ddd;


    public String getBbb() {
        return bbb;
    }

    public void setBbb(String bbb) {
        this.bbb = bbb;
    }

    public String getCcc() {
        return ccc;
    }

    public void setCcc(String ccc) {
        this.ccc = ccc;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    @Override
    public String toString() {
        return "ConfigGet{" +
                "bbb='" + bbb + '\'' +
                ", ccc='" + ccc + '\'' +
                ", ddd='" + ddd + '\'' +
                '}';
    }
}
