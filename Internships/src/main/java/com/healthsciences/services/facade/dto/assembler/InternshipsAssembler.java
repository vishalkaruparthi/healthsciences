package com.healthsciences.services.facade.dto.assembler;

import java.util.ArrayList;
import java.util.List;

import com.healthsciences.services.domain.model.HoursWork;
import com.healthsciences.services.domain.model.Internship;
import com.healthsciences.services.domain.model.State;
import com.healthsciences.services.domain.repositories.criteria.InternshipListCriteria;
import com.healthsciences.services.facade.dto.entities.GetInternshipsListCriteriaDTO;
import com.healthsciences.services.facade.dto.entities.HoursWorkDTO;
import com.healthsciences.services.facade.dto.entities.InternshipDetailsDTO;
import com.healthsciences.services.facade.dto.entities.InternshipsListDTO;
import com.healthsciences.services.facade.dto.entities.StateDTO;

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
		internshipDetails.setCity(internship.getCity());
		internshipDetails.setZipcode(internship.getZipcode());
		internshipDetails.setSpecialSkills(internship.getSpecial_Skills());
		internshipDetails.setPaytype(internship.getPay_type());
		internshipDetails.setPayamount(internship.getPay_Amount());
		internshipDetails.setPostedDate(internship.getPosted_Date());
		StateDTO state = new StateDTO();
		state.setStateid(internship.getState().getStateID());
		state.setState_name(internship.getState().getName());
		internshipDetails.setStateId(state);
	}
	public static void getIntenshipListCriteria2IntershipListCriteria(GetInternshipsListCriteriaDTO getCriteria, InternshipListCriteria listCriteria){
		listCriteria.setStateID(getCriteria.getStateID());
		listCriteria.setRecordType(getCriteria.getRecordType());
		switch (getCriteria.getSortCriteria()) {
			case 10:
				listCriteria.setOrderField("posted_Date");
				listCriteria.setOrderType("desc");
				break;
				
			case 11:
				listCriteria.setOrderField("posted_Date");
				listCriteria.setOrderType("asc");
				break;
				
			case 20:
				listCriteria.setOrderField("pay_Amount");
				listCriteria.setOrderType("desc");
				break;
				
			case 21:
				listCriteria.setOrderField("pay_Amount");
				listCriteria.setOrderType("asc");
				break;
				
			case 30:
				listCriteria.setOrderField("organizationName");
				listCriteria.setOrderType("desc");
				break;
				
			case 31:
				listCriteria.setOrderField("organizationName");
				listCriteria.setOrderType("asc");
				break;
				
			default:
				listCriteria.setOrderField("posted_Date");
				break;
			}
		
	}
	
	public static void InternshipList2InternshipListDTO(List<Internship> intenshiplist, InternshipsListDTO listDTO){
		List<InternshipDetailsDTO> intenshipListDTO =  new ArrayList<InternshipDetailsDTO>();
		for (Internship internship : intenshiplist) {
			InternshipDetailsDTO internshipDetails = new InternshipDetailsDTO();
			InternshipsAssembler.Internship2InternshipdetailsDTO(internship, internshipDetails);
			intenshipListDTO.add(internshipDetails);
		}
		listDTO.setInternshipList(intenshipListDTO);
	}
	public static void InternshipDetailsDTO2InternshipDetails(InternshipDetailsDTO detailsDTO, Internship internship){
		internship.setInternshipID(detailsDTO.getInternshipID());
		internship.setOrganizationName(detailsDTO.getOrganizationName());
		internship.setURL(detailsDTO.getURL());
		internship.setContactPerson(detailsDTO.getContactPerson());
		internship.setPhoneNumber(detailsDTO.getPhoneNumber());
		internship.setEmail(detailsDTO.getEmail());
		internship.setInternTypeID(detailsDTO.getInternTypeID());
		internship.setInternDesc(detailsDTO.getInternDesc());
		internship.setCity(detailsDTO.getCity());
		internship.setZipcode(detailsDTO.getZipcode());
		internship.setSpecial_Skills(detailsDTO.getSpecialSkills());
		internship.setPay_type(detailsDTO.getPaytype());
		internship.setPay_Amount(detailsDTO.getPayamount());
		internship.setPosted_Date(detailsDTO.getPostedDate());	
	
		State state = new State();
		state.setStateID(detailsDTO.getStateId().getStateid());
		state.setName(detailsDTO.getStateId().getState_name());
		internship.setState(state);
		
		HoursWork hoursWork = new HoursWork();
		hoursWork.setHoursID(detailsDTO.getHours_work().getHoursID());
		hoursWork.setHours_week(detailsDTO.getHours_work().getHours_week());
		hoursWork.setTitle(detailsDTO.getHours_work().getTitle());
		hoursWork.setTotal_hours(detailsDTO.getHours_work().getTotalHours());
		internship.setHours_work(hoursWork);			
		
	}
	

	
}
