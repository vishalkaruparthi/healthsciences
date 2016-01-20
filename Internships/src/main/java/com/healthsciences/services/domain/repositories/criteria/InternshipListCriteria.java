package com.healthsciences.services.domain.repositories.criteria;

public class InternshipListCriteria extends BaseSearchCriteria{
	private Integer stateID;
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
