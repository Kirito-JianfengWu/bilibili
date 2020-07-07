package com.se7en.bilibili.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "authority_role")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@IdClass(AuthorityRolePrimaryKey.class)
public class AuthorityRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(name = "authorityid", nullable = false, columnDefinition = "varchar(255) comment '权限ID(UUID)'")
	private String authorityid;

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(name = "roleid", nullable = false, columnDefinition = "varchar(255) comment '角色ID(UUID)'")
	private String roleid;

}
