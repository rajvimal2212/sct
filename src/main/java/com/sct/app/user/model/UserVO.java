package com.sct.app.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TBL_USER")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserVO {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID ")
	private Long id;

	@Column(name = "USERNAME ")
	private String username;

	@Column(name = "PASSWORD ")
	private String password;

	@Column(name = "EMAIL ")
	private String email;

	@Column(name = "ISADMIN ")
	private String isadmin;

	@Column(name = "IS_TECH ")
	private String is_tech;

	public String getIs_tech() {
		return is_tech;
	}

	public void setIs_tech(String is_tech) {
		this.is_tech = is_tech;
	}

	public UserVO() {
		super();

	}

	public UserVO(Long id, String username, String password, String email, String isadmin, String is_tech) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.isadmin = isadmin;
		this.is_tech = is_tech;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}
}
