package com.se7en.bilibili.repository;

import com.se7en.bilibili.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String>{
    Role findByRolename(String rolename);
}
