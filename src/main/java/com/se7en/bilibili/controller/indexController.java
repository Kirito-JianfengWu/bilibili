package com.se7en.bilibili.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class indexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    // 将"/"请求响应到login页面
    public String hello() {
//        System.out.println("(/, "+simpleDateFormat.format(new Date())+")");

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() {
//        System.out.println("(/login, "+simpleDateFormat.format(new Date())+")");

        return "index";
    }

}
