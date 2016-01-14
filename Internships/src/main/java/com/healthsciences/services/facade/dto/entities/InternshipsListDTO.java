package com.healthsciences.services.facade.dto.entities;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="internlist")
public class InternshipsListDTO {
	private List<InternshipDetailsDTO> internshipList;

	public List<InternshipDetailsDTO> getInternshipList() {
		return internshipList;
	}

	public void setInternshipList(
			List<InternshipDetailsDTO> internshipList) {
		this.internshipList = internshipList;
	}
	
}
