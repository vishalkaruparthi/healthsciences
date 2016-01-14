package com.healthsciences.services.domain.repositories.criteria;

public class InternshipListCriteria extends BaseSearchCriteria{
	private Integer stateID;

	public Integer getStateID() {
		return stateID;
	}

	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}
}
