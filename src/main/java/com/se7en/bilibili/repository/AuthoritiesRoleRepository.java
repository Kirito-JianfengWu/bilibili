package com.se7en.bilibili.repository;

import com.se7en.bilibili.entity.AuthoritiesRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRoleRepository extends JpaRepository<AuthoritiesRole, String>{
    AuthoritiesRole findByAuthoritiesid(String authoritiesid);
    AuthoritiesRole findByRoleid(String roleid);
}
