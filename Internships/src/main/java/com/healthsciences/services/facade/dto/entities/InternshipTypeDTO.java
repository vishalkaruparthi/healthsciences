package com.healthsciences.services.facade.dto.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="internshipType")
public class InternshipTypeDTO {
	private Integer id;
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
