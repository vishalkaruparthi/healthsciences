package com.healthsciences.services.facade.interfaces;

import com.healthsciences.services.facade.dto.entities.InternshipDetailsDTO;

public interface IInternShipsService {
	InternshipDetailsDTO getInternshipDetails(Integer internshipid);
}
