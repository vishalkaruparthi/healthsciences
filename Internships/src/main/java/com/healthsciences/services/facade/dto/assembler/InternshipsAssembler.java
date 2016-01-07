package com.healthsciences.services.facade.dto.assembler;

import com.healthsciences.services.domain.model.Internship;
import com.healthsciences.services.facade.dto.entities.HoursWorkDTO;
import com.healthsciences.services.facade.dto.entities.InternshipDetailsDTO;

public class InternshipsAssembler {
	private InternshipsAssembler(){
		
	}
	public static void Internship2InternshipdetailsDTO(Internship internship, InternshipDetailsDTO internshipDetails){
		internshipDetails.setInternshipID(internship.getInternshipID());
		internshipDetails.setOrganizationName(internship.getOrganizationName());
		internshipDetails.setURL(internship.getURL());
		internshipDetails.setContactPerson(internship.getContactPerson());
		internshipDetails.setPhoneNumber(internship.getPhoneNumber());
		internshipDetails.setEmail(internship.getEmail());
		internshipDetails.setInternTypeID(internship.getInternTypeID());
		internshipDetails.setInternDesc(internship.getInternDesc());
		HoursWorkDTO hours_work = new HoursWorkDTO();
		hours_work.setHoursID(internship.getHours_work().getHoursID());
		hours_work.setHours_week(internship.getHours_work().getHours_week());
		hours_work.setTitle(internship.getHours_work().getTitle());
		hours_work.setTotalHours(internship.getHours_work().getTotal_hours());
		internshipDetails.setHours_work(hours_work);
	}
}
