package com.healthsciences.services.facade.interfaces;

import com.healthsciences.services.facade.dto.entities.GetInternshipsListCriteriaDTO;
import com.healthsciences.services.facade.dto.entities.InternshipDetailsDTO;
import com.healthsciences.services.facade.dto.entities.InternshipsListDTO;

public interface IInternShipsService {
	InternshipDetailsDTO getInternshipDetails(Integer internshipid);
	InternshipsListDTO getInternshipList(GetInternshipsListCriteriaDTO getCriteria);
	String setInternships(InternshipDetailsDTO setDetails);
}
