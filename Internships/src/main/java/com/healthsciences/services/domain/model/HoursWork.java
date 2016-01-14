package com.healthsciences.services.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hours_work")
public class HoursWork extends AbstractEntity<Integer>{
	@Id
	@GeneratedValue
	@Column(name="Hours_ID")
	private Integer hoursID;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Hours_Week")
	private String hours_week;
	
	@Column(name="Total_Hours")
	private Integer total_hours;

	public Integer getHoursID() {
		return hoursID;
	}

	public void setHoursID(Integer hoursID) {
		this.hoursID = hoursID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHours_week() {
		return hours_week;
	}

	public void setHours_week(String hours_week) {
		this.hours_week = hours_week;
	}

	public Integer getTotal_hours() {
		return total_hours;
	}

	public void setTotal_hours(Integer total_hours) {
		this.total_hours = total_hours;
	}
		
}
