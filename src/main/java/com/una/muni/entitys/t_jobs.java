package com.una.muni.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_jobs")
public class t_jobs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String job_id;
	private String job_title;

	public t_jobs() {
		this(null, null);
	}

	public t_jobs(String job_id, String job_title) {
		this.job_id = job_id;
		this.job_title = job_title;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

}
