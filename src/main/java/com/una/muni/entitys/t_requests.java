package com.una.muni.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_requests")
public class t_requests {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String request_id;
	private String title;
	private String description;
	

	public t_requests(String request_id, String title, String description) {
		super();
		this.request_id = request_id;
		this.title = title;
		this.description = description;
	}

	public t_requests() {
		this(null, null, null);
	}

	public String getRequest_id() {
		return request_id;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
