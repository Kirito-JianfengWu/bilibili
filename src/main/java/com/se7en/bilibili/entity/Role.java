package com.se7en.bilibili.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "role")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(name = "roleid", nullable = false)
	private String roleid;

	@Column(name = "rolename", nullable = false)
	private String rolename;

}
