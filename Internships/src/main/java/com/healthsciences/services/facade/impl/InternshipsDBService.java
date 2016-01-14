package com.healthsciences.services.facade.impl;

import java.util.List;

import org.springframework.aop.IntroductionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthsciences.services.domain.model.Internship;
import com.healthsciences.services.domain.repositories.IInternshipRepository;
import com.healthsciences.services.domain.repositories.criteria.InternshipListCriteria;
import com.healthsciences.services.facade.dto.assembler.InternshipsAssembler;
import com.healthsciences.services.facade.dto.entities.GetInternshipsListCriteriaDTO;
import com.healthsciences.services.facade.dto.entities.InternshipDetailsDTO;
import com.healthsciences.services.facade.dto.entities.InternshipsListDTO;
import com.healthsciences.services.facade.dto.entities.StateListDTO;
import com.healthsciences.services.facade.interfaces.*;

@Service
@Transactional
public class InternshipsDBService implements IInternShipsService{

	@Autowired
	IInternshipRepository internshipRepo;
	
	public InternshipDetailsDTO getInternshipDetails(Integer internshipid) {
		
		Internship internship = internshipRepo.get(internshipid);
		InternshipDetailsDTO internshipDetails = new InternshipDetailsDTO();
		InternshipsAssembler.Internship2InternshipdetailsDTO(internship, internshipDetails);
		return internshipDetails;
	}

	public InternshipsListDTO getInternshipList(
			GetInternshipsListCriteriaDTO getCriteria) {
		InternshipListCriteria listCriteria = new InternshipListCriteria();
		InternshipsListDTO listDTO = new InternshipsListDTO();
		InternshipsAssembler.getIntenshipListCriteria2IntershipListCriteria(getCriteria, listCriteria);
		List<Internship> internships = (List<Internship>) internshipRepo.getInternshipList(listCriteria);
		InternshipsAssembler.InternshipList2InternshipListDTO(internships, listDTO);
		return listDTO;
	}

	public String setInternships(InternshipDetailsDTO setDetails) {
		// TODO Auto-generated method stub
		String status;
		try {
			//InternshipDetailsDTO detailsDTO = new InternshipDetailsDTO();
			Internship internship = new Internship();
			InternshipsAssembler.InternshipDetailsDTO2InternshipDetails(setDetails, internship);
			internshipRepo.save(internship);
			status = "success";
		} catch (Exception e) {
			// TODO: handle exception
			status = "fail "+e.toString();
		}
		return status;
	}
	
	
}
