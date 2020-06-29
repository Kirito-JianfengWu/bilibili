package com.se7en.bilibili.repository;

import com.se7en.bilibili.entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities, String>{
    Authorities findByAuthoritiesname(String authoritiesname);
}
