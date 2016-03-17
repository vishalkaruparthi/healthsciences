package com.healthsciences.services.facade.dto.entities;

import java.util.HashMap;
import java.util.List;
import java.util.SortedSet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
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
	 */
	private Integer sortCriteria;
	
	private List<Integer> hoursWork;
	
	private List<Integer> academicPeriod;
	
	private List<Integer> internType;

	private Integer payType;

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




	public Integer getPayType() {
		return payType;
	}




	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	
	
	

	
}
