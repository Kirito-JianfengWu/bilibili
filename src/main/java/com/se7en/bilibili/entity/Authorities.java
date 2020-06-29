package com.se7en.bilibili.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "authorities")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Authorities implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(name = "authoritiesid", nullable = false)
	private String authoritiesid;

	@Column(name = "authoritiesname", nullable = false)
	private String authoritiesname;

}
