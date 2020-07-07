package com.se7en.bilibili.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_role")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(name = "userid", nullable = false, columnDefinition = "varchar(255) comment '用户ID(UUID)'")
	private String userid;

	@Column(name = "username", nullable = false, columnDefinition = "varchar(255) comment '用户名称'")
	private String username;

	@Column(name = "roleid", nullable = false, columnDefinition = "varchar(255) comment '角色ID(UUID)'")
	private String roleid;

	@Column(name = "password", nullable = false, columnDefinition = "varchar(255) comment '密码'")
	private String password;

	@Column(name = "gender", columnDefinition = "varchar(255) comment '性别'")
	private String gender;

	@Column(name = "email", columnDefinition = "varchar(255) comment '邮箱'")
	private String email;

}
