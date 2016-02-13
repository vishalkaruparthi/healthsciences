package com.healthsciences.services.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.IntroductionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.util.concurrent.Service.State;
import com.healthsciences.services.domain.model.AcademicPeriod;
import com.healthsciences.services.domain.model.AcademicPeriodInternship;
import com.healthsciences.services.domain.model.Internship;
import com.healthsciences.services.domain.repositories.IAcadPeriodInternRepository;
import com.healthsciences.services.domain.repositories.IAcadPeriodRepository;
import com.healthsciences.services.domain.repositories.IInternshipRepository;
import com.healthsciences.services.domain.repositories.criteria.InternshipListCriteria;
import com.healthsciences.services.facade.dto.assembler.InternshipsAssembler;
import com.healthsciences.services.facade.dto.entities.AcademicPeriodDTO;
import com.healthsciences.services.facade.dto.entities.GetInternshipsListCriteriaDTO;
import com.healthsciences.services.facade.dto.entities.InternshipDetailsDTO;
import com.healthsciences.services.facade.dto.entities.InternshipsListDTO;
import com.healthsciences.services.facade.dto.entities.StateListDTO;
import com.healthsciences.services.facade.exceptions.FacadeConstraintException;
import com.healthsciences.services.facade.exceptions.FacadeEntityNotFoundExpection;
import com.healthsciences.services.facade.exceptions.FacadeUnknownException;
import com.healthsciences.services.facade.interfaces.*;

@Service
@Transactional
public class InternshipsDBService implements IInternShipsService{

	@Autowired
	IInternshipRepository internshipRepo;
	IAcadPeriodInternRepository acadPeriodInternRepo;
	IAcadPeriodRepository acadPeriodRepo;
	
	public InternshipDetailsDTO getInternshipDetails(Integer internshipid) throws FacadeEntityNotFoundExpection, FacadeUnknownException{
		try {
			Internship internship = internshipRepo.get(internshipid);
			if(internship == null){
				throw new FacadeEntityNotFoundExpection(Internship.class, internshipid);
			}
			InternshipDetailsDTO internshipDetails = new InternshipDetailsDTO();
			InternshipsAssembler.Internship2InternshipdetailsDTO(internship, internshipDetails);
			return internshipDetails;
		} catch (Exception e) {
			throw new FacadeUnknownException(e.getMessage());
		}
	}

	public InternshipsListDTO getInternshipList (
			GetInternshipsListCriteriaDTO getCriteria){
		InternshipListCriteria listCriteria = new InternshipListCriteria();
		InternshipsListDTO listDTO = new InternshipsListDTO();
		InternshipsAssembler.getIntenshipListCriteria2IntershipListCriteria(getCriteria, listCriteria);
		List<Internship> internships = (List<Internship>) internshipRepo.getInternshipList(listCriteria);
		InternshipsAssembler.InternshipList2InternshipListDTO(internships, listDTO);
		return listDTO;
	}

	public String setInternships(InternshipDetailsDTO setDetails) throws FacadeConstraintException{
		String status;
		try {
			Internship internship = new Internship();
			InternshipsAssembler.InternshipDetailsDTO2InternshipDetails(setDetails, internship);
			internshipRepo.save(internship);
			internship.getInternshipID();
			status = internship.getInternshipID().toString();
			
			for (AcademicPeriodDTO current : setDetails.getAcademicPeriodList().getAcademicPeriodList()) {
				AcademicPeriodInternship temp = new AcademicPeriodInternship();
				temp.setAcademicPeriod(acadPeriodRepo.get(current.getId()));
				temp.setInternship(internshipRepo.get(internship.getInternshipID()));
				acadPeriodInternRepo.save(temp);
			}
			
			return status;
		} catch (Exception e) {
			throw new FacadeConstraintException(e.getMessage());
		}
		
	}

	public boolean approveInternship(Integer internshipID) {
		try{
			internshipRepo.get(internshipID).setRecordStatus("APPROVED");
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	
}
