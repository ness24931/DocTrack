package com.una.muni.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_employees database table.
 * 
 */
@Entity
@Table(name="t_employees")
@NamedQuery(name="TEmployee.findAll", query="SELECT t FROM TEmployee t")
public class TEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMPLOYEE_ID", unique=true, nullable=false)
	private int employeeId;

	@Column(nullable=false, length=20)
	private String dni;

	@Column(nullable=false, length=50)
	private String email;

	@Column(name="FIRST_NAME", nullable=false, length=50)
	private String firstName;

	@Column(name="FIRST_SURNAME", length=50)
	private String firstSurname;

	@Column(name="SECOND_SURNAME", length=50)
	private String secondSurname;

	@Column(length=10)
	private String status;

	@Column(nullable=false, length=25)
	private String telephone;

	//bi-directional many-to-one association to TDepartment
//	@OneToMany(mappedBy="TEmployee")
//	private List<TDepartment> TDepartments;
//	@OneToMany(mappedBy="TEmployee1")
//	private List<TDepartment> TDepartments1;

	//bi-directional many-to-one association to TDepartment
//	@OneToMany(mappedBy="TEmployee2")
//	private List<TDepartment> TDepartments2;

	//bi-directional many-to-one association to TDepartment
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="DEPARTMENT_ID", nullable=false)
	private TDepartment TDepartment;
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="DEPARTMENT_ID", nullable=false)
//	private TDepartment TDepartment1;

	//bi-directional many-to-one association to TDepartment
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="DEPARTMENT_ID", nullable=false)
//	private TDepartment TDepartment2;

	//bi-directional many-to-one association to TJob
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="JOB_ID", nullable=false)
	private TJob TJob;	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="JOB_ID", nullable=false)
//	private TJob TJob1;

	//bi-directional many-to-one association to TJob
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="JOB_ID", nullable=false)
//	private TJob TJob2;

	//bi-directional many-to-one association to TResolution
	@OneToMany(mappedBy="TEmployee")
	private List<TResolution> TResolutions;

	//bi-directional many-to-one association to TTicket
	@OneToMany(mappedBy="TEmployee")
	private List<TTicket> TTickets;

	//bi-directional many-to-one association to TUser
//	@OneToOne(mappedBy="TEmployee")
//	private List<TUser> TUsers;	
//	@OneToMany(mappedBy="TEmployee1")
//	private List<TUser> TUsers1;

	//bi-directional many-to-one association to TUser
//	@OneToMany(mappedBy="TEmployee2")
//	private List<TUser> TUsers2;

	public TEmployee() {
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstSurname() {
		return this.firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public String getSecondSurname() {
		return this.secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	
	
//	public List<TDepartment> getTDepartments() {
//		return this.TDepartments;
//	}
//
//	public void setTDepartments(List<TDepartment> TDepartments) {
//		this.TDepartments = TDepartments;
//	}
//
//	public TDepartment addTDepartments(TDepartment TDepartments) {
//		getTDepartments().add(TDepartments);
//		TDepartments.setTEmployee(this);
//
//		return TDepartments;
//	}
//
//	public TDepartment removeTDepartments(TDepartment TDepartments) {
//		getTDepartments().remove(TDepartments);
//		TDepartments.setTEmployee(null);
//
//		return TDepartments;
//	}

//	public List<TDepartment> getTDepartments1() {
//		return this.TDepartments1;
//	}
//
//	public void setTDepartments1(List<TDepartment> TDepartments1) {
//		this.TDepartments1 = TDepartments1;
//	}
//
//	public TDepartment addTDepartments1(TDepartment TDepartments1) {
//		getTDepartments1().add(TDepartments1);
//		TDepartments1.setTEmployee1(this);
//
//		return TDepartments1;
//	}
//
//	public TDepartment removeTDepartments1(TDepartment TDepartments1) {
//		getTDepartments1().remove(TDepartments1);
//		TDepartments1.setTEmployee1(null);
//
//		return TDepartments1;
//	}

//	public List<TDepartment> getTDepartments2() {
//		return this.TDepartments2;
//	}
//
//	public void setTDepartments2(List<TDepartment> TDepartments2) {
//		this.TDepartments2 = TDepartments2;
//	}
//
//	public TDepartment addTDepartments2(TDepartment TDepartments2) {
//		getTDepartments2().add(TDepartments2);
//		TDepartments2.setTEmployee2(this);
//
//		return TDepartments2;
//	}
//
//	public TDepartment removeTDepartments2(TDepartment TDepartments2) {
//		getTDepartments2().remove(TDepartments2);
//		TDepartments2.setTEmployee2(null);
//
//		return TDepartments2;
//	}

	public TDepartment getTDepartment() {
		return this.TDepartment;
	}

	public void setTDepartment(TDepartment TDepartment) {
		this.TDepartment = TDepartment;
	}
	
//	public TDepartment getTDepartment1() {
//		return this.TDepartment1;
//	}
//
//	public void setTDepartment1(TDepartment TDepartment1) {
//		this.TDepartment1 = TDepartment1;
//	}

//	public TDepartment getTDepartment2() {
//		return this.TDepartment2;
//	}
//
//	public void setTDepartment2(TDepartment TDepartment2) {
//		this.TDepartment2 = TDepartment2;
//	}
	
	public TJob getTJob() {
		return this.TJob;
	}

	public void setTJob(TJob TJob) {
		this.TJob = TJob;
	}

//	public TJob getTJob1() {
//		return this.TJob1;
//	}
//
//	public void setTJob1(TJob TJob1) {
//		this.TJob1 = TJob1;
//	}

//	public TJob getTJob2() {
//		return this.TJob2;
//	}
//
//	public void setTJob2(TJob TJob2) {
//		this.TJob2 = TJob2;
//	}

	public List<TResolution> getTResolutions() {
		return this.TResolutions;
	}

	public void setTResolutions(List<TResolution> TResolutions) {
		this.TResolutions = TResolutions;
	}

	public TResolution addTResolution(TResolution TResolution) {
		getTResolutions().add(TResolution);
		TResolution.setTEmployee(this);

		return TResolution;
	}

	public TResolution removeTResolution(TResolution TResolution) {
		getTResolutions().remove(TResolution);
		TResolution.setTEmployee(null);

		return TResolution;
	}

	public List<TTicket> getTTickets() {
		return this.TTickets;
	}

	public void setTTickets(List<TTicket> TTickets) {
		this.TTickets = TTickets;
	}

	public TTicket addTTicket(TTicket TTicket) {
		getTTickets().add(TTicket);
		TTicket.setTEmployee(this);

		return TTicket;
	}

	public TTicket removeTTicket(TTicket TTicket) {
		getTTickets().remove(TTicket);
		TTicket.setTEmployee(null);

		return TTicket;
	}

	public TEmployee(int employeeId, String dni, String email, String firstName, String firstSurname,
			String secondSurname, String status, String telephone, com.una.muni.model.TDepartment tDepartment) {
		this.employeeId = employeeId;
		this.dni = dni;
		this.email = email;
		this.firstName = firstName;
		this.firstSurname = firstSurname;
		this.secondSurname = secondSurname;
		this.status = status;
		this.telephone = telephone;
		TDepartment = tDepartment;
	}
	
//	public List<TUser> getTUsers() {
//		return this.TUsers;
//	}
//
//	public void setTUsers(List<TUser> TUsers) {
//		this.TUsers = TUsers;
//	}
//
//	public TUser addTUsers(TUser TUsers) {
//		getTUsers().add(TUsers);
//		TUsers.setTEmployee(this);
//
//		return TUsers;
//	}
//
//	public TUser removeTUsers(TUser TUsers) {
//		getTUsers().remove(TUsers);
//		TUsers.setTEmployee(null);
//
//		return TUsers;
//	}

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
//		TUsers1.setTEmployee1(this);
//
//		return TUsers1;
//	}
//
//	public TUser removeTUsers1(TUser TUsers1) {
//		getTUsers1().remove(TUsers1);
//		TUsers1.setTEmployee1(null);
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
//
//	public TUser addTUsers2(TUser TUsers2) {
//		getTUsers2().add(TUsers2);
//		TUsers2.setTEmployee2(this);
//
//		return TUsers2;
//	}
//
//	public TUser removeTUsers2(TUser TUsers2) {
//		getTUsers2().remove(TUsers2);
//		TUsers2.setTEmployee2(null);
//
//		return TUsers2;
//	}

}

