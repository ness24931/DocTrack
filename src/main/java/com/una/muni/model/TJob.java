package com.una.muni.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_jobs database table.
 * 
 */
@Entity
@Table(name="t_jobs")
@NamedQuery(name="TJob.findAll", query="SELECT t FROM TJob t")
public class TJob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="JOB_ID", unique=true, nullable=false)
	private int jobId;

	@Column(name="JOB_TITLE", nullable=false, length=50)
	private String jobTitle;

	//me la vole
	//bi-directional many-to-one association to TEmployee
//	@OneToMany(mappedBy="TJob")
//	private List<TEmployee> TEmployees;
	
//	@OneToMany(mappedBy="TJob1")
//	private List<TEmployee> TEmployees1;

	//bi-directional many-to-one association to TEmployee
//	@OneToMany(mappedBy="TJob2")
//	private List<TEmployee> TEmployees2;

	public TJob() {
		//nothing
	}

	public int getJobId() {
		return this.jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
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
//		TEmployees.setTJob(this);
//
//		return TEmployees;
//	}
//
//	public TEmployee removeTEmployees(TEmployee TEmployees) {
//		getTEmployees().remove(TEmployees);
//		TEmployees.setTJob(null);
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
//		TEmployees1.setTJob1(this);
//
//		return TEmployees1;
//	}
//
//	public TEmployee removeTEmployees1(TEmployee TEmployees1) {
//		getTEmployees1().remove(TEmployees1);
//		TEmployees1.setTJob1(null);
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
//		TEmployees2.setTJob2(this);
//
//		return TEmployees2;
//	}
//
//	public TEmployee removeTEmployees2(TEmployee TEmployees2) {
//		getTEmployees2().remove(TEmployees2);
//		TEmployees2.setTJob2(null);
//
//		return TEmployees2;
//	}

}