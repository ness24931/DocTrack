package com.una.muni.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_clients database table.
 * 
 */
@Entity
@Table(name="t_clients")
@NamedQuery(name="TClient.findAll", query="SELECT t FROM TClient t")
public class TClient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CLIENT_ID", unique=true, nullable=false)
	private int clientId;

	@Column(nullable=false, length=50)
	private String email;

	@Column(name="FIRST_NAME", nullable=false, length=50)
	private String firstName;

	@Column(name="FIRST_SURNAME", length=50)
	private String firstSurname;

	@Column(name="SECOND_SURNAME", length=50)
	private String secondSurname;

	@Column(nullable=false, length=25)
	private String telephone;

	//bi-directional many-to-one association to TTicket
	@OneToMany(mappedBy="TClient")
	private List<TTicket> TTickets;

	public TClient() {
	}

	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
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

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<TTicket> getTTickets() {
		return this.TTickets;
	}

	public void setTTickets(List<TTicket> TTickets) {
		this.TTickets = TTickets;
	}

	public TTicket addTTicket(TTicket TTicket) {
		getTTickets().add(TTicket);
		TTicket.setTClient(this);

		return TTicket;
	}

	public TTicket removeTTicket(TTicket TTicket) {
		getTTickets().remove(TTicket);
		TTicket.setTClient(null);

		return TTicket;
	}

}