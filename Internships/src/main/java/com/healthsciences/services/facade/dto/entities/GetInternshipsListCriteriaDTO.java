package com.healthsciences.services.facade.dto.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="listcriteria")
public class GetInternshipsListCriteriaDTO {
	private Integer stateID;

	public Integer getStateID() {
		return stateID;
	}

	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}
}
