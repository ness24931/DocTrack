package com.una.muni.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_requirements database table.
 * 
 */
@Entity
@Table(name="t_requirements")
@NamedQuery(name="TRequirement.findAll", query="SELECT t FROM TRequirement t")
public class TRequirement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="REQUIREMENT_ID", unique=true, nullable=false)
	private int requirementId;

	@Column(nullable=false, length=250)
	private String title;
	
	@Column(nullable=false, length=1000)
	private String description;

	// bi-directional many-to-one association to TRequest
	// @ManyToOne(fetch=FetchType.EAGER)
	// @JoinColumn(name="REQUEST_ID"/*, nullable=false*/)
	// private TRequest TRequest;
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="REQUEST_ID", nullable=false)
//	private TRequest TRequest1;

	//bi-directional many-to-one association to TRequest
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="REQUEST_ID", nullable=false)
//	private TRequest TRequest2;

	public TRequirement() {
	}

	public int getRequirementId() {
		return this.requirementId;
	}

	public void setRequirementId(int requirementId) {
		this.requirementId = requirementId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// public TRequest getTRequest() {
	// 	return this.TRequest;
	// }

	// public void setTRequest(TRequest TRequest) {
	// 	this.TRequest = TRequest;
	// }

//	public TRequest getTRequest1() {
//		return this.TRequest1;
//	}
//
//	public void setTRequest1(TRequest TRequest1) {
//		this.TRequest1 = TRequest1;
//	}
//
//	public TRequest getTRequest2() {
//		return this.TRequest2;
//	}
//
//	public void setTRequest2(TRequest TRequest2) {
//		this.TRequest2 = TRequest2;
//	}

}