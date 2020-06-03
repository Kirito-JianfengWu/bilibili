package com.se7en.bilibili.entity;

import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;

@Data
@Entity
@Table(name = "authorities_role")
public class AuthoritiesRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String authoritiesid;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RoleID")
	private String roleid;

}
