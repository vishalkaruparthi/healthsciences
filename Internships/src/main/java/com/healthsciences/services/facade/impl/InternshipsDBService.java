package com.healthsciences.services.facade.impl;

import org.springframework.aop.IntroductionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthsciences.services.domain.model.Internship;
import com.healthsciences.services.domain.repositories.IInternshipRepository;
import com.healthsciences.services.facade.dto.assembler.InternshipsAssembler;
import com.healthsciences.services.facade.dto.entities.InternshipDetailsDTO;
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
}
