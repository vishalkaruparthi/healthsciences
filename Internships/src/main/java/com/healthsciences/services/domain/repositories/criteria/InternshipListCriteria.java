package com.healthsciences.services.domain.repositories.criteria;

import java.util.List;
import java.util.SortedSet;

public class InternshipListCriteria extends BaseSearchCriteria{
	private Integer stateID;
	private Integer sortCriteria;
	private List<Integer> internType;
	private List<Integer> hoursWork;
	private List<Integer> academicPeriod;
	private Integer payType;


	public List<Integer> getHoursWork() {
		return hoursWork;
	}

	public void setHoursWork(List<Integer> hoursWork) {
		this.hoursWork = hoursWork;
	}

	public List<Integer> getAcademicPeriod() {
		return academicPeriod;
	}

	public void setAcademicPeriod(List<Integer> academicPeriod) {
		this.academicPeriod = academicPeriod;
	}

	public List<Integer> getInternType() {
		return internType;
	}

	public void setInternType(List<Integer> internType) {
		this.internType = internType;
	}

	
	
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

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

}
