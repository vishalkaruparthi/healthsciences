package com.healthsciences.services.facade.dto.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.LocalDateTime;

import com.healthsciences.services.domain.model.HoursWork;

@XmlRootElement(name = "internship")
public class InternshipDetailsDTO {
	
	private Integer internshipID;
	private String organizationName;
	private String url;
	private String contactPerson;
	private String phoneNumber;
	private String email;
	private String internDesc;
	private String city;
	private String zipcode;
	private String specialSkills;
	private String payamount;
	private LocalDateTime postedDate;
	private StateDTO stateId;
	private String status;
	private List<InternshipTypeDTO> internshipTypeList;
	private List<AcademicPeriodDTO> academicPeriodList;
	private List<HoursWorkDTO> hoursWorkList;
	private PayTypeDTO payType;
	


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
	public String getInternDesc() {
		return internDesc;
	}
	public void setInternDesc(String internDesc) {
		this.internDesc = internDesc;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public PayTypeDTO getPayType() {
		return payType;
	}
	public void setPayType(PayTypeDTO payType) {
		this.payType = payType;
	}
	public List<AcademicPeriodDTO> getAcademicPeriodList() {
		return academicPeriodList;
	}
	public void setAcademicPeriodList(List<AcademicPeriodDTO> academicPeriodList) {
		this.academicPeriodList = academicPeriodList;
	}
	public List<HoursWorkDTO> getHoursWorkList() {
		return hoursWorkList;
	}
	public void setHoursWorkList(List<HoursWorkDTO> hoursWorkList) {
		this.hoursWorkList = hoursWorkList;
	}
	public List<InternshipTypeDTO> getInternshipTypeList() {
		return internshipTypeList;
	}
	public void setInternshipTypeList(List<InternshipTypeDTO> internshipTypeList) {
		this.internshipTypeList = internshipTypeList;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
