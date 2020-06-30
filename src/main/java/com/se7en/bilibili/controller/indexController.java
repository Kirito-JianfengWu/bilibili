package com.se7en.bilibili.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class indexController {

    @RequestMapping(value = "/")
    // 将"/"请求响应到login页面
    public String hello() {

        return "login";
    }

    @RequestMapping(value = "/login")
    public String login() {

        return "index";
    }

    @RequestMapping(value = "/loginError")
    public String loginError() {

        return "login";
    }

    @RequestMapping(value="/logout")
    public String logout (HttpServletRequest request, HttpServletResponse response) {
        // Authentication是一个接口, 表示用户认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 如果用户认知信息不为空, 注销
        if (authentication != null){
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        // 重定向到login页面
        return "redirect:/?logout";
    }

}
