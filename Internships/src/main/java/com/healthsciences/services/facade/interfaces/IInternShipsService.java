package com.healthsciences.services.facade.interfaces;

import com.healthsciences.services.facade.dto.entities.GetInternshipsListCriteriaDTO;
import com.healthsciences.services.facade.dto.entities.InternshipDetailsDTO;
import com.healthsciences.services.facade.dto.entities.InternshipsListDTO;
import com.healthsciences.services.facade.exceptions.FacadeConstraintException;
import com.healthsciences.services.facade.exceptions.FacadeEntityNotFoundExpection;
import com.healthsciences.services.facade.exceptions.FacadeUnknownException;

public interface IInternShipsService {
	InternshipDetailsDTO getInternshipDetails(Integer internshipid) throws FacadeEntityNotFoundExpection, FacadeUnknownException;
	InternshipsListDTO getInternshipList(GetInternshipsListCriteriaDTO getCriteria);
	String setInternships(InternshipDetailsDTO setDetails) throws FacadeConstraintException;
	boolean approveInternship(Integer internshipID);
}
