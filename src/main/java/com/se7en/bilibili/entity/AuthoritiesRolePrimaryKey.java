package com.se7en.bilibili.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * AuthoritiesRole的多主键配置类
 */
@Data
public class AuthoritiesRolePrimaryKey implements Serializable {

    private static final long serialVersionUID = 1L;

    private String authoritiesid;

    private String roleid;
}
