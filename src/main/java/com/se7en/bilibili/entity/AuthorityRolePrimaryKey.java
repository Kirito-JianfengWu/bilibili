package com.se7en.bilibili.entity;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * AuthorityRole的多主键配置类
 */
@Data
public class AuthorityRolePrimaryKey implements Serializable {

    private static final long serialVersionUID = 1L;

    private String authorityid;

    private String roleid;
}
