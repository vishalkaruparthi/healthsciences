package com.healthsciences.services.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hourswork_intership")
public class HoursWorkInternship extends AbstractEntity<Integer>{
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public HoursWork getHoursWork() {
		return hoursWork;
	}

	public void setHoursWork(HoursWork hoursWork) {
		this.hoursWork = hoursWork;
	}

	public Internship getInternship() {
		return internship;
	}

	public void setInternship(Internship internship) {
		this.internship = internship;
	}

	@ManyToOne
	@JoinColumn(name="hoursID")
	private HoursWork hoursWork;
	
	@ManyToOne
	@JoinColumn(name="internID")
	private Internship internship;
	
}
