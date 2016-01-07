package com.healthsciences.services.facade.dto.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="hours_work")
public class HoursWorkDTO {
	private Integer hoursID;
	private String title;
	private String hours_week;
	private Integer totalHours;
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
	public Integer getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(Integer totalHours) {
		this.totalHours = totalHours;
	}
	
	
}
