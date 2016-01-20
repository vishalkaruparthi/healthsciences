package com.healthsciences.services.facade.dto.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="listcriteria")
public class GetInternshipsListCriteriaDTO {
	private Integer stateID;
	/*
	 * 10 posted_Date desc
	 * 11 posted_Date asc
	 * 
	 * 20 pay_Amount desc
	 * 21 pay_Amount asc
	 * 
	 * 30 organizationName desc
	 * 31 organizationName asc
	 * 
	 *  
	 */
	private Integer sortCriteria;
	
	public Integer getStateID() {
		return stateID;
	}

	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}

	public Integer getSortCriteria() {
		return sortCriteria;
	}

	public void setSortCriteria(Integer sortCriteria) {
		this.sortCriteria = sortCriteria;
	}


	
}
