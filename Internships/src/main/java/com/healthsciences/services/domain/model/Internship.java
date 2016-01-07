package com.healthsciences.services.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
