package com.healthsciences.services.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="interntype")
public class InternshipType extends AbstractEntity<Integer>{

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="title")
	private String title;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
