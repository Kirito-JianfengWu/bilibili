package com.se7en.bilibili.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class indexController {

    //Spring Security BCrypt加密方式
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    //设置日期格式
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        System.out.println("(/, "+simpleDateFormat.format(new Date())+")");
        return "login";
    }

    @RequestMapping(value = "/login")
    public String login() {
        System.out.println("(/, "+simpleDateFormat.format(new Date())+")");
        return "login";
    }
}
