package com.una.muni.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_roles database table.
 * 
 */
@Entity
@Table(name="t_roles")
@NamedQuery(name="TRole.findAll", query="SELECT t FROM TRole t")
public class TRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ROLE_ID", unique=true, nullable=false)
	private int roleId;

	@Column(nullable=false, length=50)
	private String name;

	//bi-directional many-to-one association to TUser
	// @OneToMany(mappedBy="TRole")
	// private List<TUser> TUsers;
//	@OneToMany(mappedBy="TRole1")
//	private List<TUser> TUsers1;

	//bi-directional many-to-one association to TUser
//	@OneToMany(mappedBy="TRole2")
//	private List<TUser> TUsers2;

	public TRole() {
	}
	
	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TRole(int roleId, String name) {
		this.roleId = roleId;
		this.name = name;
	}
	
	// public List<TUser> getTUsers() {
	// 	return this.TUsers;
	// }

	// public void setTUsers(List<TUser> TUsers) {
	// 	this.TUsers = TUsers;
	// }

	// public TUser addTUsers(TUser TUsers) {
	// 	getTUsers().add(TUsers);
	// 	TUsers.setTRole(this);

	// 	return TUsers;
	// }

	// public TUser removeTUsers(TUser TUsers) {
	// 	getTUsers().remove(TUsers);
	// 	TUsers.setTRole(null);

	// 	return TUsers;
	// }
	
	
	//codigo generado

//	public List<TUser> getTUsers1() {
//		return this.TUsers1;
//	}
//
//	public void setTUsers1(List<TUser> TUsers1) {
//		this.TUsers1 = TUsers1;
//	}
//
//	public TUser addTUsers1(TUser TUsers1) {
//		getTUsers1().add(TUsers1);
//		TUsers1.setTRole1(this);
//
//		return TUsers1;
//	}
//
//	public TUser removeTUsers1(TUser TUsers1) {
//		getTUsers1().remove(TUsers1);
//		TUsers1.setTRole1(null);
//
//		return TUsers1;
//	}

//	public List<TUser> getTUsers2() {
//		return this.TUsers2;
//	}
//
//	public void setTUsers2(List<TUser> TUsers2) {
//		this.TUsers2 = TUsers2;
//	}
	
//	public TUser addTUsers2(TUser TUsers2) {
//		getTUsers2().add(TUsers2);
//		TUsers2.setTRole2(this);
//
//		return TUsers2;
//	}
//
//	public TUser removeTUsers2(TUser TUsers2) {
//		getTUsers2().remove(TUsers2);
//		TUsers2.setTRole2(null);
//
//		return TUsers2;
//	}

}