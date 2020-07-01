package com.se7en.bilibili.security;

import com.se7en.bilibili.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 安全配置类
 * 认证处理类需继承WebSecurityConfigurerAdapter, 重写对应方法来完成相关认证处理
 */
@Configuration
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    AppAuthenticationSuccessHandler appAuthenticationSuccessHandler;

    @Autowired
    private UserService userService;

    // 依赖注入加密接口
    @Autowired
    private PasswordEncoder passwordEncoder;

    // 依赖注入用户认证接口
    @Autowired
    private AuthenticationProvider authenticationProvider;

    // BCryptPasswordEncoder是Spring Security提供的PasswordEncoder接口的实现类
    // 用来创建密码的加密程序，避免明文存储密码到数据库
    // 在这里添加配置类报错, 因为形成了循环引用
    // Caused by: org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'passwordEncoder': Requested bean is currently in creation: Is there an unresolvable circular reference?
    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        // 不要隐藏UserNotFoundExceptions异常
        daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
        // 通过重写configuration方法添加自定义的认证方式
        daoAuthenticationProvider.setUserDetailsService(userService);
        // 设置密码加密方式
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);

        return daoAuthenticationProvider;
    }

    // 用户自定义认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    // 设置了登陆页面, 而且登陆页面任何人都可以访问, 然后设置了登陆失败地址, 也设置了注销请求, 注销请求也是任何人都可以访问的
    // .permitAll() 表示请求任何人都可以访问
    // .anyRequest().authenticated() 表示其他的请求都必须要有权限认证
    // .headers().frameOptions().disable() 表示取消禁止网页被Frame, 使得网页可以被Frame[Spring Security默认使用X-Frame-Options防止网页被Frame]
    // .csrf().disable() 表示关闭Spring Security的跨域保护(CSRF Protection)
    // .failureUrl("/") 表示登录失败后发送的请求[GET]
    // .successHandler(appAuthenticationSuccessHandler).successHandler(appAuthenticationSuccessHandler) 登录成功处理, 可以按权限分别进入不同的登录页面
    // .defaultSuccessUrl("/login") 登录成功后默认的页面
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers( "/", "/css/**", "/webjars/**", "/html/loader.html", "/images/**", "/js/**").permitAll()
                .antMatchers("/login").hasRole("ADMIN")
                .antMatchers("/login").hasRole("USER")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .failureForwardUrl("/loginError")
                .defaultSuccessUrl("/html/index.html")
                .and()
            .logout().permitAll()
                .and()
            .exceptionHandling()
                .accessDeniedPage("/accessDenied")
                .and()
            .headers()
                .frameOptions().disable()
                .and()
            .csrf().disable();
    }
}
