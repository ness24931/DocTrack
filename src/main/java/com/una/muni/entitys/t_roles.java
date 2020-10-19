package com.una.muni.entitys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_roles")
public class t_roles implements Serializable {
	private static final long serialVersionUID = 2723227416828669932L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int role_id;
	private String name;

	public t_roles() {
		this(0, null);
	}

	public t_roles(int role_id, String name) {
		this.role_id = role_id;
		this.name = name;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
