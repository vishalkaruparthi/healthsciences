package com.healthsciences.services.facade.dto.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="internshipTypeList")
public class InternshipTypeListDTO {
	private List<InternshipTypeDTO> internshipTypeList;

	public List<InternshipTypeDTO> getInternshipTypeList() {
		return internshipTypeList;
	}

	public void setInternshipTypeList(List<InternshipTypeDTO> internshipTypeList) {
		this.internshipTypeList = internshipTypeList;
	}
	
}
