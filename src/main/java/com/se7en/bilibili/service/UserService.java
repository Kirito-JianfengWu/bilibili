package com.se7en.bilibili.service;

import com.se7en.bilibili.entity.Role;
import com.se7en.bilibili.entity.UserRole;
import com.se7en.bilibili.repository.AuthoritiesRepository;
import com.se7en.bilibili.repository.AuthoritiesRoleRepository;
import com.se7en.bilibili.repository.RoleRepository;
import com.se7en.bilibili.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * 需要实现UserDetailsService接口
 * 因为在Spring Security中配置的相关参数需要是UserDetailsService类型的数据
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    private AuthoritiesRoleRepository authoritiesRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    // 初始化角色, 默认为ROLE_ADMIN和ROLE_USER
    public void InitRole() {
        boolean isRoleAdminExist = false;
        boolean isRoleUserExist = false;
        List<Role> roleList = roleRepository.findAll();
        for (Role role : roleList) {
            if ("ROLE_ADMIN".equals(role.getRolename())) {
                isRoleAdminExist = true;
            }
            if ("ROLE_USER".equals(role.getRolename())) {
                isRoleUserExist = true;
            }
        }
        if (!isRoleAdminExist) {
            Role roleAdmin = new Role();
            roleAdmin.setRolename("ROLE_ADMIN");
            roleRepository.save(roleAdmin);
        }

        if (!isRoleUserExist) {
            Role roleUser = new Role();
            roleUser.setRolename("ROLE_USER");
            roleRepository.save(roleUser);
        }
    }

    @Transactional
    // 添加默认超级管理员用户
    public void InitSuperAdminUserRole() {
        boolean isAdminUserRoleExist = false;
        List<UserRole> userRoleList = userRoleRepository.findAll();
        List<Role> roles = roleRepository.findAll();
        String roleId = "";
        for (Role role : roles) {
            if ("ROLE_ADMIN".equals(role.getRolename())) {
                roleId = role.getRoleid();
            }
        }
        for (UserRole userRole : userRoleList) {
            if ("Jianfeng Wu".equals(userRole.getUsername())) {
                isAdminUserRoleExist = true;
                break;
            }
        }
        if (!isAdminUserRoleExist) {
            UserRole userRole = new UserRole();
            userRole.setUsername("Jianfeng Wu");
            userRole.setRoleid(roleId);
            userRole.setPassword(passwordEncoder.encode("888888"));
            userRole.setGender("男");
            userRole.setEmail("695804696@qq.com");
            userRoleRepository.save(userRole);
        }
    }

    @Transactional
    // Spring Security .failureForwardUrl("/loginError") 登录验证失败时判断登录时输入的账号密码, 返回相关提示信息
    public String SpringSecurityFailureForwardUrlMessage(String username) {
        UserRole userRole = userRoleRepository.findByUsername(username);
        if (userRole == null) {
            return "用户名不存在!";
        }

        return "用户密码错误!";
    }

    // 重写UserDetailsService接口中的loadUserByUsername方法, 通过该方法查询到对应的用户
    // 返回对象UserDetails是Spring Security中一个核心的接口
    // 其中定义了一些可以获取用户名、密码、权限等与认证相关的信息的方法
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 调用持久层接口findByUsername方法查找用户, 此处传进来的参数实际是userName
        // findByUsername方法通过JPA进行数据库验证传递的参数是页面接收到的userName
        UserRole userRole = userRoleRepository.findByUsername(username);
        if (userRole == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 创建List集合, 用来保存用户权限, GrantedAuthority对象代表赋予给当前用户的权限
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        // 获得当前用户权限
        // 将关联对象Role的Rolename属性保存为用户的认证权限
        grantedAuthorityList.add(new SimpleGrantedAuthority(roleRepository.findByRoleid(userRole.getRoleid()).getRolename()));
        // 此处返回的是org.springframework.security.core.userdetails.User类
        // 该类是Spring Security内部的实现, 专门用于保存用户名、密码、权限等与认证相关的信息

        return new User(username, userRole.getPassword(), grantedAuthorityList);
    }
}
