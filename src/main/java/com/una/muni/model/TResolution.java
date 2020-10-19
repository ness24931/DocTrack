package com.una.muni.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_resolutions database table.
 * 
 */
@Entity
@Table(name="t_resolutions")
@NamedQuery(name="TResolution.findAll", query="SELECT t FROM TResolution t")
public class TResolution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RESOLUTION_ID", unique=true, nullable=false)
	private int resolutionId;

	@Column(length=1000)
	private String description;

	//bi-directional many-to-one association to TEmployee
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="EMPLOYEE_ID", nullable=false)
	private TEmployee TEmployee;

	//bi-directional many-to-one association to TTicket
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TICKET_ID", nullable=false)
	private TTicket TTicket;

	public TResolution() {
	}

	public int getResolutionId() {
		return this.resolutionId;
	}

	public void setResolutionId(int resolutionId) {
		this.resolutionId = resolutionId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TEmployee getTEmployee() {
		return this.TEmployee;
	}

	public void setTEmployee(TEmployee TEmployee) {
		this.TEmployee = TEmployee;
	}

	public TTicket getTTicket() {
		return this.TTicket;
	}

	public void setTTicket(TTicket TTicket) {
		this.TTicket = TTicket;
	}

}