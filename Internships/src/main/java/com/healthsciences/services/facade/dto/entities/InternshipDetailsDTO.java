package com.healthsciences.services.facade.dto.entities;

import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.LocalDateTime;

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
	private String city;
	private String zipcode;
	private String specialSkills;
	private String paytype;
	private String payamount;
	private LocalDateTime postedDate;
	private StateDTO stateId;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getSpecialSkills() {
		return specialSkills;
	}
	public void setSpecialSkills(String specialSkills) {
		this.specialSkills = specialSkills;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public String getPayamount() {
		return payamount;
	}
	public void setPayamount(String payamount) {
		this.payamount = payamount;
	}
	public LocalDateTime getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(LocalDateTime postedDate) {
		this.postedDate = postedDate;
	}
	public StateDTO getStateId() {
		return stateId;
	}
	public void setStateId(StateDTO stateId) {
		this.stateId = stateId;
	}
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
