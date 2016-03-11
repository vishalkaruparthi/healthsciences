package com.healthsciences.services.domain.repositories;

import java.util.ArrayList;
import java.util.List;

import com.healthsciences.services.domain.model.Internship;
import com.healthsciences.services.domain.repositories.criteria.InternshipListCriteria;
import com.healthsciences.services.facade.dto.entities.InternshipDetailsDTO;

public interface IInternshipRepository extends IBaseRepository<Internship>{
	List<Object> getInternshipList(InternshipListCriteria listCriteria);
	//String setInternshipDetails(InternshipDetailsDTO internshipDetails);	
}
