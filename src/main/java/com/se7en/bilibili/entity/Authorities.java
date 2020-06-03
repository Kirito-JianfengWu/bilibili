package com.se7en.bilibili.entity;

import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;

@Data
@Entity
@Table(name = "authorities")
public class Authorities implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AuthoritiesID")
	private String authoritiesid;

	@Column(name = "AuthoritiesName")
	private String authoritiesname;

}
