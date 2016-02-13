package com.healthsciences.services.infrastructure.persistence.hibernate;

import org.springframework.stereotype.Repository;

import com.healthsciences.services.domain.model.AcademicPeriodInternship;
import com.healthsciences.services.domain.repositories.IAcadPeriodInternRepository;
import com.healthsciences.services.domain.repositories.criteria.BaseSearchCriteria;

@Repository
public class AcadPeriodInternRepository extends BaseRepository<AcademicPeriodInternship, BaseSearchCriteria> implements IAcadPeriodInternRepository{
	
}
