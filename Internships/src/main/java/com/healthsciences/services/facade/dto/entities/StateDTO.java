package com.healthsciences.services.facade.dto.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="state_details")

public class StateDTO {
	private Integer stateid;
	private String state_name;
	public Integer getStateid() {
		return stateid;
	}
	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	
	
}
