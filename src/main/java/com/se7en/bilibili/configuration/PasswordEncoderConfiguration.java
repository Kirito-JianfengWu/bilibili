package com.se7en.bilibili.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfiguration {

    // BCryptPasswordEncoder是Spring Security提供的PasswordEncoder接口的实现类
    // 用来创建密码的加密程序, 避免明文存储密码到数据库
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
