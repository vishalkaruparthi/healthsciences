package com.healthsciences.services.domain.repositories.criteria;

public class InternshipListCriteria extends BaseSearchCriteria{
	private Integer stateID;
	private Integer sortCriteria;
	private String recordType;
	
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

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}


	
	
}
