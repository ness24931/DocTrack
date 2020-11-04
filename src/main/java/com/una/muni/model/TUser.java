package com.una.muni.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the t_users database table.
 * 
 */
@Entity
@Table(name = "t_users")
@NamedQuery(name = "TUser.findAll", query = "SELECT t FROM TUser t")
public class TUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID", unique=true, nullable=false)
	private int userId;

	@Column(nullable = false, length = 15)
	private String username;

	@Column(nullable = false, length = 50)
	private String passwd;

	@Column(length = 20)
	private String status;

	// bi-directional many-to-one association to TEmployee
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID")
	private TEmployee TEmployee;
//	private TEmployee TEmployee1;

//	//bi-directional many-to-one association to TEmployee
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="EMPLOYEE_ID")
//	private TEmployee TEmployee2;

	// bi-directional many-to-one association to TRole
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROLE_ID", nullable = false)
	private TRole TRole;
//	private TRole TRole1;

//	//bi-directional many-to-one association to TRole
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="ROLE_ID", nullable=false)
//	private TRole TRole2;

	// @OneToOne(fetch = FetchType.EAGER)
	// @JoinColumn(name = "CLIENT_ID",nullable = false)
	// private TClient TCliente;

	public TUser() {
	}
	
	

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TEmployee getTEmployee() {
		return this.TEmployee;
	}

	public void setTEmployee(TEmployee TEmployee) {
		this.TEmployee = TEmployee;
	}

	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

	

	public TUser(String username, String passwd, String status, com.una.muni.model.TEmployee tEmployee,
			com.una.muni.model.TRole tRole) {
		this.username = username;
		this.passwd = passwd;
		this.status = status;
		TEmployee = tEmployee;
		TRole = tRole;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

//	public TEmployee getTEmployee1() {
//		return this.TEmployee1;
//	}
//
//	public void setTEmployee1(TEmployee TEmployee1) {
//		this.TEmployee1 = TEmployee1;
//	}
//
//	public TEmployee getTEmployee2() {
//		return this.TEmployee2;
//	}
//
//	public void setTEmployee2(TEmployee TEmployee2) {
//		this.TEmployee2 = TEmployee2;
//	}
//
//	public TRole getTRole1() {
//		return this.TRole1;
//	}
//
//	public void setTRole1(TRole TRole1) {
//		this.TRole1 = TRole1;
//	}
//
//	public TRole getTRole2() {
//		return this.TRole2;
//	}
//
//	public void setTRole2(TRole TRole2) {
//		this.TRole2 = TRole2;
//	}

}