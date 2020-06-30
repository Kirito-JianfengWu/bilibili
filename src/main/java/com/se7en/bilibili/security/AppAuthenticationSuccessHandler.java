package com.se7en.bilibili.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class AppAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    // Spring Security通过RedirectStrategy类对象负责所有重定向事务
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    // 重写handle方法, 方法中通过RedirectStrategy对象重定向到指定的url
    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 通过determineTargetUrl方法返回需要跳转的url
        String targetUrl = determineTargetUrl(authentication, request.getContextPath());
        // 重定向请求到指定的url
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    // 从Authentication类对象中提取当前登录用户的角色, 并根据其角色返回适当的URL
    private String determineTargetUrl(Authentication authentication, String requestContextPath) {
        String url = "";

        // 获取当前登录用户的角色权限集合
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<String> roleList = new ArrayList<>();

        for (GrantedAuthority grantedAuthority : authorities) {
            roleList.add(grantedAuthority.getAuthority());
        }

        // 判断不同角色跳转到不同的url
        if ((isAdmin(roleList) || isUser(roleList))) {
            url = "/html/index.html";
        } else {
            url = "/accessDenied";
        }

        return url;
    }

    private boolean isAdmin(List<String> roleList) {
        return roleList.contains("ROLE_ADMIN");
    }

    private boolean isUser(List<String> roleList) {
        return roleList.contains("ROLE_USER");
    }

}
