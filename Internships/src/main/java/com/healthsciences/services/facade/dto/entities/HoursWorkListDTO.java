package com.healthsciences.services.facade.dto.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="hoursWorkList")
public class HoursWorkListDTO {
	private List<HoursWorkDTO> hoursWorkList;

	public List<HoursWorkDTO> getHoursWorkList() {
		return hoursWorkList;
	}

	public void setHoursWorkList(List<HoursWorkDTO> hoursWorkList) {
		this.hoursWorkList = hoursWorkList;
	}
	
}
