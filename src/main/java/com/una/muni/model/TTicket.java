package com.una.muni.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_tickets database table.
 * 
 */
@Entity
@Table(name="t_tickets")
@NamedQuery(name="TTicket.findAll", query="SELECT t FROM TTicket t")
public class TTicket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TICKET_ID", unique=true, nullable=false)
	private int ticketId;

	@Column(name="DEPARTMENT_ID", nullable=false)
	private int departmentId;

	@Column(length=1000)
	private String description;

	@Column(nullable=false, length=20)
	private String estado;

	@Column(nullable=false, length=100)
	private String title;

	//bi-directional many-to-one association to TResolution
	@OneToMany(mappedBy="TTicket")
	private List<TResolution> TResolutions;

	//bi-directional many-to-one association to TClient
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CLIENT_ID", nullable=false)
	private TClient TClient;

	//bi-directional many-to-one association to TEmployee
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="EMPLOYEE_ID", nullable=false)
	private TEmployee TEmployee;

	//bi-directional many-to-one association to TRequest
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="REQUEST_ID", nullable=false)
	private TRequest TRequest;

	public TTicket() {
	}

	public int getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<TResolution> getTResolutions() {
		return this.TResolutions;
	}

	public void setTResolutions(List<TResolution> TResolutions) {
		this.TResolutions = TResolutions;
	}

	public TResolution addTResolution(TResolution TResolution) {
		getTResolutions().add(TResolution);
		TResolution.setTTicket(this);

		return TResolution;
	}

	public TResolution removeTResolution(TResolution TResolution) {
		getTResolutions().remove(TResolution);
		TResolution.setTTicket(null);

		return TResolution;
	}

	public TClient getTClient() {
		return this.TClient;
	}

	public void setTClient(TClient TClient) {
		this.TClient = TClient;
	}

	public TEmployee getTEmployee() {
		return this.TEmployee;
	}

	public void setTEmployee(TEmployee TEmployee) {
		this.TEmployee = TEmployee;
	}

	public TRequest getTRequest() {
		return this.TRequest;
	}

	public void setTRequest(TRequest TRequest) {
		this.TRequest = TRequest;
	}

}