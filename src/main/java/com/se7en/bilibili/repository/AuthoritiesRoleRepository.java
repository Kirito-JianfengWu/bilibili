package com.se7en.bilibili.repository;

import com.se7en.bilibili.entity.AuthorityRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRoleRepository extends JpaRepository<AuthorityRole, String>{

    AuthorityRole findByAuthorityid(String authoritiesid);

    AuthorityRole findByRoleid(String roleid);
}
