package com.healthsciences.services.facade.dto.assembler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.joda.time.LocalDateTime;

import com.healthsciences.services.domain.model.AcademicPeriod;
import com.healthsciences.services.domain.model.AcademicPeriodInternship;
import com.healthsciences.services.domain.model.HoursWork;
import com.healthsciences.services.domain.model.HoursWorkInternship;
import com.healthsciences.services.domain.model.Internship;
import com.healthsciences.services.domain.model.InternshipType;
import com.healthsciences.services.domain.model.InternshiptypeInternship;
import com.healthsciences.services.domain.model.PayType;
import com.healthsciences.services.domain.model.State;
import com.healthsciences.services.domain.repositories.criteria.InternshipListCriteria;
import com.healthsciences.services.facade.dto.entities.AcademicPeriodDTO;
import com.healthsciences.services.facade.dto.entities.GetInternshipsListCriteriaDTO;
import com.healthsciences.services.facade.dto.entities.HoursWorkDTO;
import com.healthsciences.services.facade.dto.entities.InternshipDetailsDTO;
import com.healthsciences.services.facade.dto.entities.InternshipTypeDTO;
import com.healthsciences.services.facade.dto.entities.InternshipsListDTO;
import com.healthsciences.services.facade.dto.entities.PayTypeDTO;
import com.healthsciences.services.facade.dto.entities.StateDTO;

public class InternshipsAssembler {
	private InternshipsAssembler(){
		
	}
	public static void Internship2InternshipdetailsDTO(Internship internship, InternshipDetailsDTO internshipDetails){
		internshipDetails.setInternshipID(internship.getInternshipID());
		internshipDetails.setOrganizationName(internship.getOrganizationName());
		internshipDetails.setUrl(internship.getUrl());
		internshipDetails.setContactPerson(internship.getContactPerson());
		internshipDetails.setPhoneNumber(internship.getPhoneNumber());
		internshipDetails.setEmail(internship.getEmail());
		internshipDetails.setInternDesc(internship.getInternDesc());
		internshipDetails.setCity(internship.getCity());
		internshipDetails.setZipcode(internship.getZipcode());
		internshipDetails.setSpecialSkills(internship.getSpecial_Skills());
		internshipDetails.setPayamount(internship.getPay_Amount());
		internshipDetails.setPostedDate(internship.getPosted_Date());
		
		StateDTO state = new StateDTO();
		state.setStateid(internship.getState().getStateID());
		state.setState_name(internship.getState().getName());
		internshipDetails.setStateId(state);
		internshipDetails.setStatus(internship.getRecordStatus());
		
		List<InternshipTypeDTO> internshipTypeListDTO = new ArrayList<InternshipTypeDTO>();
		InternshipTypeList2InternrshipTypeListDTO(internship.getInternshipType(), internshipTypeListDTO);
		internshipDetails.setInternshipTypeList(internshipTypeListDTO);
		
		List<AcademicPeriodDTO> academicPeriodListDTO = new ArrayList<AcademicPeriodDTO>();
		AcademicPeriodsList2AcademicPeriodsListDTO(internship.getAcademicPeriods(), academicPeriodListDTO);
		internshipDetails.setAcademicPeriodList(academicPeriodListDTO);
		
		List<HoursWorkDTO> hoursWorkListDTO = new ArrayList<HoursWorkDTO>();
		HoursWorkListHoursWorkListDTO(internship.getHoursWork() ,hoursWorkListDTO);
		internshipDetails.setHoursWorkList(hoursWorkListDTO);
		
		PayTypeDTO payTypeDTO = new PayTypeDTO();
		payTypeDTO.setId(internship.getPayType().getId());
		payTypeDTO.setTitle(internship.getPayType().getTitle());
		internshipDetails.setPayType(payTypeDTO);
		
	}
	
	public static void HoursWorkListHoursWorkListDTO(List<HoursWorkInternship> list, List<HoursWorkDTO> listDTO){
		for (HoursWorkInternship hoursWorkInternship : list) {
			HoursWorkDTO temp = new HoursWorkDTO();
			temp.setHoursID(hoursWorkInternship.getHoursWork().getHoursID());
			temp.setTitle(hoursWorkInternship.getHoursWork().getTitle());
			temp.setHours_week(hoursWorkInternship.getHoursWork().getHours_week());
			temp.setTotalHours(hoursWorkInternship.getHoursWork().getTotal_hours());
			listDTO.add(temp);
		}
	}
	
	public static void AcademicPeriodsList2AcademicPeriodsListDTO(List<AcademicPeriodInternship> list, List<AcademicPeriodDTO> listDTO){
		for (AcademicPeriodInternship academicPeriodInternship : list) {
			AcademicPeriodDTO temp = new AcademicPeriodDTO();
			temp.setId(academicPeriodInternship.getAcademicPeriod().getId());
			temp.setTitle(academicPeriodInternship.getAcademicPeriod().getTitle());
			listDTO.add(temp);
		}
	}
	
	public static void InternshipTypeList2InternrshipTypeListDTO(List<InternshiptypeInternship> List, List<InternshipTypeDTO> listDTO){
		for (InternshiptypeInternship internshiptypeInternship : List) {
			InternshipTypeDTO internshipTypeDTO = new InternshipTypeDTO();
			internshipTypeDTO.setId(internshiptypeInternship.getInternshipType().getId());
			internshipTypeDTO.setTitle(internshiptypeInternship.getInternshipType().getTitle());
			listDTO.add(internshipTypeDTO);
		}
	}
	
	
	public static void getIntenshipListCriteria2IntershipListCriteria(GetInternshipsListCriteriaDTO getCriteria, InternshipListCriteria listCriteria){
		listCriteria.setStateID(getCriteria.getStateID());
		listCriteria.setHoursWork(getCriteria.getHoursWork());
		listCriteria.setInternType(getCriteria.getInternType());
		listCriteria.setSortCriteria(getCriteria.getSortCriteria());
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
	
	public static void InternshipList2InternshipListDTO(List<Object> intenshiplist, InternshipsListDTO listDTO){
		List<InternshipDetailsDTO> intenshipListDTO =  new ArrayList<InternshipDetailsDTO>();
		System.out.println("LIST::::"+intenshiplist.size());
		Iterator<Object> pairsIt = intenshiplist.iterator();
		List<Integer> internIDs = new ArrayList<Integer>();
		while(pairsIt.hasNext()){
		    Object[] pair = (Object[]) pairsIt.next();
		    System.out.println(pair[0]);
		    Internship internship = (Internship) pair[0];
		    InternshipDetailsDTO internshipDetails = new InternshipDetailsDTO();
		    InternshipsAssembler.Internship2InternshipdetailsDTO(internship, internshipDetails);
		    
		    if(!internIDs.contains(internshipDetails.getInternshipID())){
		    	internIDs.add(internshipDetails.getInternshipID());
		    	intenshipListDTO.add(internshipDetails);
		    }
		 
		}
//		for (Object internship : intenshiplist) {
//			InternshipDetailsDTO internshipDetails = new InternshipDetailsDTO();
//			System.out.println(internship.getClass());
//			System.out.println(internship);
//			InternshipsAssembler.Internship2InternshipdetailsDTO(internship, internshipDetails);
//			intenshipListDTO.add(internshipDetails);
//		}
		listDTO.setInternshipList(intenshipListDTO);
	}
	public static void InternshipDetailsDTO2InternshipDetails(InternshipDetailsDTO detailsDTO, Internship internship){
		internship.setOrganizationName(detailsDTO.getOrganizationName());
		internship.setUrl(detailsDTO.getUrl());
		internship.setContactPerson(detailsDTO.getContactPerson());
		internship.setPhoneNumber(detailsDTO.getPhoneNumber());
		internship.setEmail(detailsDTO.getEmail());
		internship.setInternDesc(detailsDTO.getInternDesc());
		internship.setCity(detailsDTO.getCity());
		internship.setZipcode(detailsDTO.getZipcode());
		internship.setSpecial_Skills(detailsDTO.getSpecialSkills());
		internship.setPay_Amount(detailsDTO.getPayamount());
		internship.setPosted_Date(LocalDateTime.now());
		internship.setRecordStatus(detailsDTO.getStatus());

		State state = new State();
		state.setStateID(detailsDTO.getStateId().getStateid());
		state.setName(detailsDTO.getStateId().getState_name());
		internship.setState(state);
		
		PayType payType = new PayType();
		payType.setId(detailsDTO.getPayType().getId());
		internship.setPayType(payType);
		
	}
	

}
