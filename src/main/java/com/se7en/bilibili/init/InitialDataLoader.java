package com.se7en.bilibili.init;

import com.se7en.bilibili.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Spring Boot启动时初始化基础数据
 */
@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    UserService userService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        userService.InitRole();

        userService.InitSuperAdminUserRole();

        alreadySetup = true;
    }
}
