package com.se7en.bilibili.repository;

import com.se7en.bilibili.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authority, String>{

    Authority findByAuthorityid(String authoritiesid);

    Authority findByAuthorityname(String authoritiesname);
}
