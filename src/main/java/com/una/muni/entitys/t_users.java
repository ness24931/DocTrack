package com.una.muni.entitys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_users")
public class t_users {
	@Id
	private String username;
	private String passwd;
	@OneToOne
	@JoinColumn(name = "role_id")
	private t_roles role_id;
	@OneToOne
	@JoinColumn(name = "employee_id")
	private t_employees employee_id;
	private String status;

	public t_users() {
		this(null, null, null, null, null);
	}

	public t_users(String username, String passwd, t_roles role_id, t_employees employee_id, String status) {
		this.username = username;
		this.passwd = passwd;
		this.role_id = role_id;
		this.employee_id = employee_id;
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public t_roles getRole_id() {
		return role_id;
	}

	public void setRole_id(t_roles role_id) {
		this.role_id = role_id;
	}

	public t_employees getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(t_employees employee_id) {
		this.employee_id = employee_id;
	}
}
