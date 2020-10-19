package com.una.muni.entitys;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "t_requirements")
public class t_requirements {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String requirement_id;
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private t_requests request_id;

	public t_requirements() {
		this(null, null, null);
	}

	public t_requirements(String requirement_id, String description, t_requests request_id) {
		this.requirement_id = requirement_id;
		this.description = description;
		this.request_id = request_id;

	}

	public String getRequirement_id() {
		return requirement_id;
	}

	public void setRequirement_id(String requirement_id) {
		this.requirement_id = requirement_id;
	}

	public t_requests getRequest_id() {
		return request_id;
	}

	public void setRequest_id(t_requests request_id) {
		this.request_id = request_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
