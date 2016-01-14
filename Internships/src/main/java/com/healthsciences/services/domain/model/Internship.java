package com.healthsciences.services.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name ="internship_details")
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
	
	@Column(name="Internship_Type_ID")
	private String internTypeID;
	
	@Column(name="Internship_Description")
	private String internDesc;
	
	
	@ManyToOne
	@JoinColumn(name="Hours_ID", nullable=false)
	private HoursWork hours_work;
	
	@Column(name="City")
	private String city;
	
	@Column(name="Zipcode")
	private String zipcode;
	
	@Column(name="Special_Skills")
	private String special_Skills;
	
	@Column(name="Pay_Type")
	private String pay_type;
	
	@Column(name="Pay_Amount")
	private String pay_Amount;
	

	@Column(name="Posted_Date")
	@Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
	private org.joda.time.LocalDateTime posted_Date;
	
	@ManyToOne
	@JoinColumn(name="State_ID")
	private State state;
	
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

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
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

	public HoursWork getHours_work() {
		return hours_work;
	}

	public void setHours_work(HoursWork hours_work) {
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
