package com.una.muni.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_employees")
public class t_employees {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ID")
	private int employee_id;
	private String dni;
	private String first_name;
	private String first_surname;
	private String second_surname;
	private String email;
	private String telephone;
	@OneToOne	
	@JoinColumn(name = "department_id")
	private t_departments department_id;
	@OneToOne	
	@JoinColumn(name = "job_id")
	private t_jobs job_id;
	private String status;

	public t_employees() {
		this(0, null, null, null, null, null, null, null, null, null);
	}

	public t_employees(int employee_id, String dni, String first_name, String first_surname, String second_surname,
			String email, String telephone, t_departments department_id, t_jobs job_id, String status) {
		this.employee_id = employee_id;
		this.dni = dni;
		this.first_name = first_name;
		this.first_surname = first_surname;
		this.second_surname = second_surname;
		this.email = email;
		this.telephone = telephone;
		this.department_id = department_id;
		this.job_id = job_id;
		this.status = status;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getFirst_surname() {
		return first_surname;
	}

	public void setFirst_surname(String first_surname) {
		this.first_surname = first_surname;
	}

	public String getSecond_surname() {
		return second_surname;
	}

	public void setSecond_surname(String second_surname) {
		this.second_surname = second_surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public t_departments getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(t_departments department_id) {
		this.department_id = department_id;
	}

	public t_jobs getJob_id() {
		return job_id;
	}

	public void setJob_id(t_jobs job_id) {
		this.job_id = job_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
