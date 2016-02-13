package com.healthsciences.services.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="interntype_internship")
public class InternshiptypeInternship extends AbstractEntity<Integer>{
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name="interntypeID")
	private InternshipType internshipType;
	
	@ManyToOne
	@JoinColumn(name="internID")
	private Internship internship;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public InternshipType getInternshipType() {
		return internshipType;
	}

	public void setInternshipType(InternshipType internshipType) {
		this.internshipType = internshipType;
	}

	public Internship getInternship() {
		return internship;
	}

	public void setInternship(Internship internship) {
		this.internship = internship;
	}
	
}
