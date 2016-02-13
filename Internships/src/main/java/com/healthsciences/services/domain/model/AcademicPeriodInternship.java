package com.healthsciences.services.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="academicperiod_inernship")
public class AcademicPeriodInternship extends AbstractEntity<Integer>{
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="acadID")
	private AcademicPeriod academicPeriod;
	
	@ManyToOne
	@JoinColumn(name="internID")
	private Internship internship;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AcademicPeriod getAcademicPeriod() {
		return academicPeriod;
	}

	public void setAcademicPeriod(AcademicPeriod academicPeriod) {
		this.academicPeriod = academicPeriod;
	}

	public Internship getInternship() {
		return internship;
	}

	public void setInternship(Internship internship) {
		this.internship = internship;
	}
}
