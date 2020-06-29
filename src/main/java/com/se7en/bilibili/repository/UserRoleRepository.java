package com.se7en.bilibili.repository;

import com.se7en.bilibili.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, String>{
    UserRole findByUsername(String username);
}
