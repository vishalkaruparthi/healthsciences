package com.healthsciences.services.infrastructure.persistence.hibernate;

import org.springframework.stereotype.Repository;

import com.healthsciences.services.domain.model.AcademicPeriod;
import com.healthsciences.services.domain.repositories.IAcadPeriodInternRepository;
import com.healthsciences.services.domain.repositories.IAcadPeriodRepository;
import com.healthsciences.services.domain.repositories.criteria.BaseSearchCriteria;

@Repository
public class AcadPeriodRepository extends BaseRepository<AcademicPeriod, BaseSearchCriteria> implements IAcadPeriodRepository{

}
