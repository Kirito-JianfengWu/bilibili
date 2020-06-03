package com.se7en.bilibili.entity;

import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;

@Data
@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UserID")
	private String userid;

	@Column(name = "UserName")
	private String username;

	@Column(name = "RoleID")
	private String roleid;

	@Column(name = "PassWord")
	private String password;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "Email")
	private String email;

}
