package com.se7en.bilibili.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "authorities_role")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@IdClass(AuthoritiesRolePrimaryKey.class)
public class AuthoritiesRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(name = "authoritiesid", nullable = false)
	private String authoritiesid;

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(name = "roleid", nullable = false)
	private String roleid;

}
