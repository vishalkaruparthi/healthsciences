package com.healthsciences.services.facade.dto.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

public class AcademicPeriodListDTO {
	private List<AcademicPeriodDTO> academicPeriodList;

	public List<AcademicPeriodDTO> getAcademicPeriodList() {
		return academicPeriodList;
	}

	public void setAcademicPeriodList(List<AcademicPeriodDTO> academicPeriodList) {
		this.academicPeriodList = academicPeriodList;
	}
	
}
