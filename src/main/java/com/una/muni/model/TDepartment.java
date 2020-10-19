package com.una.muni.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_departments database table.
 * 
 */
@Entity
@Table(name="t_departments")
@NamedQuery(name="TDepartment.findAll", query="SELECT t FROM TDepartment t")
public class TDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DEPARTMENT_ID", unique=true, nullable=false)
	private int departmentId;

	@Column(name="DEPARTMENT_NAME", nullable=false, length=50)
	private String departmentName;

	//bi-directional many-to-one association to TEmployee
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="MANAGER_ID")
	private TEmployee TEmployee;
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="MANAGER_ID")
//	private TEmployee TEmployee1;

	//bi-directional many-to-one association to TEmployee
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="MANAGER_ID")
//	private TEmployee TEmployee2;

	//me lo vole
	//bi-directional many-to-one association to TEmployee
//	@OneToMany(mappedBy="TDepartment")
//	private List<TEmployee> TEmployees;
//	@OneToMany(mappedBy="TDepartment1")
//	private List<TEmployee> TEmployees1;

	//bi-directional many-to-one association to TEmployee
//	@OneToMany(mappedBy="TDepartment2")
//	private List<TEmployee> TEmployees2;

	public TDepartment() {
		//nothing
	}

	public int getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public TEmployee getTEmployee() {
		return this.TEmployee;
	}

	public void setTEmployee(TEmployee TEmployee) {
		this.TEmployee = TEmployee;
	}

	public TDepartment(int departmentId, String departmentName, com.una.muni.model.TEmployee tEmployee) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		TEmployee = tEmployee;
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
	
//	public List<TEmployee> getTEmployees() {
//		return this.TEmployees;
//	}
//
//	public void setTEmployees(List<TEmployee> TEmployees) {
//		this.TEmployees = TEmployees;
//	}
//
//	public TEmployee addTEmployees(TEmployee TEmployees) {
//		getTEmployees().add(TEmployees);
//		TEmployees.setTDepartment(this);
//
//		return TEmployees;
//	}
//
//	public TEmployee removeTEmployees(TEmployee TEmployees) {
//		getTEmployees().remove(TEmployees);
//		TEmployees.setTDepartment(null);
//
//		return TEmployees;
//	}
	

//	public List<TEmployee> getTEmployees1() {
//		return this.TEmployees1;
//	}
//
//	public void setTEmployees1(List<TEmployee> TEmployees1) {
//		this.TEmployees1 = TEmployees1;
//	}
//
//	public TEmployee addTEmployees1(TEmployee TEmployees1) {
//		getTEmployees1().add(TEmployees1);
//		TEmployees1.setTDepartment1(this);
//
//		return TEmployees1;
//	}
//
//	public TEmployee removeTEmployees1(TEmployee TEmployees1) {
//		getTEmployees1().remove(TEmployees1);
//		TEmployees1.setTDepartment1(null);
//
//		return TEmployees1;
//	}
//
//	public List<TEmployee> getTEmployees2() {
//		return this.TEmployees2;
//	}
//
//	public void setTEmployees2(List<TEmployee> TEmployees2) {
//		this.TEmployees2 = TEmployees2;
//	}
//
//	public TEmployee addTEmployees2(TEmployee TEmployees2) {
//		getTEmployees2().add(TEmployees2);
//		TEmployees2.setTDepartment2(this);
//
//		return TEmployees2;
//	}
//
//	public TEmployee removeTEmployees2(TEmployee TEmployees2) {
//		getTEmployees2().remove(TEmployees2);
//		TEmployees2.setTDepartment2(null);
//
//		return TEmployees2;
//	}

}