package com.healthsciences.services.domain.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

@Entity
@Table(name ="internship")
public class Internship extends AbstractEntity<Integer>{
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer internshipID;
	
	@Column(name="organization_Name")
	private String organizationName;
	
	@Column(name="URL")
	private String URL;
	
	@Column(name="Contact_Person_name")
	private String contactPerson;
	
	@Column(name="Phone_number")
	private String phoneNumber;
	
	@Column(name="Personal_Email")
	private String email;
	
	
	@Column(name="Internship_Description")
	private String internDesc;
	
	
	@Column(name="City")
	private String city;
	
	@Column(name="Zipcode")
	private String zipcode;
	
	@Column(name="Special_Skills")
	private String special_Skills;
	
	@Column(name="PayAmount")
	private String pay_Amount;
	

	@Column(name="Posted_Date")
	@Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
	private org.joda.time.LocalDateTime posted_Date;
	
	@ManyToOne
	@JoinColumn(name="State_ID")
	private State state;
	
	@ManyToOne
	@JoinColumn(name="PayType_ID")
	private PayType payType;
	
	public PayType getPayType() {
		return payType;
	}

	public void setPayType(PayType payType) {
		this.payType = payType;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "internship")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<AcademicPeriodInternship> academicPeriods;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "internship")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<HoursWorkInternship> hoursWork;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "internship")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<InternshiptypeInternship> internshipType;
	
	

	public List<AcademicPeriodInternship> getAcademicPeriods() {
		return academicPeriods;
	}

	public void setAcademicPeriods(List<AcademicPeriodInternship> academicPeriods) {
		this.academicPeriods = academicPeriods;
	}

	public List<HoursWorkInternship> getHoursWork() {
		return hoursWork;
	}

	public void setHoursWork(List<HoursWorkInternship> hoursWork) {
		this.hoursWork = hoursWork;
	}

	public List<InternshiptypeInternship> getInternshipType() {
		return internshipType;
	}

	public void setInternshipType(List<InternshiptypeInternship> internshipType) {
		this.internshipType = internshipType;
	}

	@Column(name="Status")
	private String recordStatus;
	
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

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

	public String getSpecial_Skills() {
		return special_Skills;
	}

	public void setSpecial_Skills(String special_Skills) {
		this.special_Skills = special_Skills;
	}


	public String getPay_Amount() {
		return pay_Amount;
	}

	public void setPay_Amount(String pay_Amount) {
		this.pay_Amount = pay_Amount;
	}



	public org.joda.time.LocalDateTime getPosted_Date() {
		return posted_Date;
	}

	public void setPosted_Date(org.joda.time.LocalDateTime posted_Date) {
		this.posted_Date = posted_Date;
	}

	public String getURL() {
		return URL;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
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
	
}
