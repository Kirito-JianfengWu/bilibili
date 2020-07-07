package com.se7en.bilibili.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "authority")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Authority implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(name = "authorityid", nullable = false)
	private String authorityid;

	@Column(name = "authorityname", nullable = false)
	private String authorityname;

}
