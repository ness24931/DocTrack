package com.una.muni.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_departments")
public class t_departments {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String department_id;
	private String department_name;
	@OneToOne
	@JoinColumn(name = "MANAGER_ID")	
	private t_employees manager_id;

	public t_departments() {
		this(null, null, null);
	}

	public t_departments(String department_id, String department_name, t_employees manager_id) {
		this.department_id = department_id;
		this.department_name = department_name;
		this.manager_id = manager_id;
	}

	public String getDepartment_id() {
		return department_id;
	}

	public void setDeparment_id(String deparment_id) {
		this.department_id = deparment_id;
	}

	public String getDeparment_name() {
		return department_name;
	}

	public void setDeparment_name(String deparment_name) {
		this.department_name = deparment_name;
	}

	public t_employees getManager_id() {
		return manager_id;
	}

	public void setManager_id(t_employees manager_id) {
		this.manager_id = manager_id;
	}

}
