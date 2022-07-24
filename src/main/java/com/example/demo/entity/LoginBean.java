package com.example.demo.entity;

public class LoginBean {//创建这个，是为了将  login接口  接进来，要用更具体的属性来接，因为index用到了用户名和密码，所以这里用用户名和密码来接。

    private String name;

    private String pwd;

    public LoginBean(String name, String pwd) {

    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override   //此处增加toString方法，就是为了验证一个能不能拿到name和pwd的这两个输入值。
    public String toString() {
        return "LoginBean{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
