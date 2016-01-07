package com.healthsciences.services.facade.dto.entities;

import javax.xml.bind.annotation.XmlRootElement;

import com.healthsciences.services.domain.model.HoursWork;

@XmlRootElement(name = "internship")
public class InternshipDetailsDTO {
	
	private Integer internshipID;
	private String organizationName;
	private String URL;
	private String contactPerson;
	private String phoneNumber;
	private String email;
	private String internTypeID;
	private String internDesc;
	private HoursWorkDTO hours_work;
	
	
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInternTypeID() {
		return internTypeID;
	}
	public void setInternTypeID(String internTypeID) {
		this.internTypeID = internTypeID;
	}
	public String getInternDesc() {
		return internDesc;
	}
	public void setInternDesc(String internDesc) {
		this.internDesc = internDesc;
	}
	public HoursWorkDTO getHours_work() {
		return hours_work;
	}
	public void setHours_work(HoursWorkDTO hours_work) {
		this.hours_work = hours_work;
	}
	public Integer getInternshipID() {
		return internshipID;
	}
	public void setInternshipID(Integer internshipID) {
		this.internshipID = internshipID;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	
}
