package com.una.muni.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistent class for the t_requests database table.
 * 
 */
@Entity
@Table(name = "t_requests")
@NamedQuery(name = "TRequest.findAll", query = "SELECT t FROM TRequest t")
public class TRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REQUEST_ID", unique = true, nullable = false)
	private int requestId;

	@Column(nullable = false, length = 1000)
	private String description;

	@Column(nullable = false, length = 250)
	private String title;

	// @JoinColumn(name = "REQUIREMENT_ID")
	@ManyToMany
	@JoinTable(name = "t_requests_requirements", joinColumns = {
			@JoinColumn(name = "REQUEST_ID") }, inverseJoinColumns = { @JoinColumn(name = "REQUIREMENT_ID") })
	private Set<TRequirement> TRequirements = new HashSet<TRequirement>();

	// bi-directional many-to-one association to TRequirement
	// @OneToMany(mappedBy="TRequest")
	// private List<TRequirement> TRequirements;
	// @OneToMany(mappedBy="TRequest1")
	// private List<TRequirement> TRequirements1;

	// bi-directional many-to-one association to TRequirement
	// @OneToMany(mappedBy="TRequest2")
	// private List<TRequirement> TRequirements2;

	// bi-directional many-to-one association to TTicket
	// @OneToMany(mappedBy="TRequest")
	// private List<TTicket> TTickets;

	public TRequest() {
	}

	public int getRequestId() {
		return this.requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<TRequirement> getTRequirements() {
		return this.TRequirements;
	}

	public void setTRequirements(Set<TRequirement> tRequirements) {
		TRequirements = tRequirements;
	}

	

	// public TRequirement addTRequirements(TRequirement TRequirements) {
	// getTRequirements().add(TRequirements);
	// TRequirements.setTRequest(this);

	// return TRequirements;
	// }

	// public TRequirement removeTRequirements(TRequirement TRequirements) {
	// getTRequirements().remove(TRequirements);
	// TRequirements.setTRequest(null);

	// return TRequirements;
	// }

	// public List<TRequirement> getTRequirements1() {
	// return this.TRequirements1;
	// }

	// public void setTRequirements1(List<TRequirement> TRequirements1) {
	// this.TRequirements1 = TRequirements1;
	// }
	//
	// public TRequirement addTRequirements1(TRequirement TRequirements1) {
	// getTRequirements1().add(TRequirements1);
	// TRequirements1.setTRequest1(this);
	//
	// return TRequirements1;
	// }
	//
	// public TRequirement removeTRequirements1(TRequirement TRequirements1) {
	// getTRequirements1().remove(TRequirements1);
	// TRequirements1.setTRequest1(null);
	//
	// return TRequirements1;
	// }
	//
	// public List<TRequirement> getTRequirements2() {
	// return this.TRequirements2;
	// }
	//
	// public void setTRequirements2(List<TRequirement> TRequirements2) {
	// this.TRequirements2 = TRequirements2;
	// }
	//
	// public TRequirement addTRequirements2(TRequirement TRequirements2) {
	// getTRequirements2().add(TRequirements2);
	// TRequirements2.setTRequest2(this);
	//
	// return TRequirements2;
	// }
	//
	// public TRequirement removeTRequirements2(TRequirement TRequirements2) {
	// getTRequirements2().remove(TRequirements2);
	// TRequirements2.setTRequest2(null);
	//
	// return TRequirements2;
	// }

	// public List<TTicket> getTTickets() {
	// return this.TTickets;
	// }
	//
	// public void setTTickets(List<TTicket> TTickets) {
	// this.TTickets = TTickets;
	// }
	//
	// public TTicket addTTicket(TTicket TTicket) {
	// getTTickets().add(TTicket);
	// TTicket.setTRequest(this);
	//
	// return TTicket;
	// }
	//
	// public TTicket removeTTicket(TTicket TTicket) {
	// getTTickets().remove(TTicket);
	// TTicket.setTRequest(null);
	//
	// return TTicket;
	// }

}