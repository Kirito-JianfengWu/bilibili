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
	@Column(name = "userid", nullable = false)
	private String userid;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "roleid", nullable = false)
	private String roleid;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "gender")
	private String gender;

	@Column(name = "email")
	private String email;

}
