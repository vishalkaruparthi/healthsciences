package com.healthsciences.services.infrastructure.persistence.hibernate;

import org.springframework.stereotype.Repository;

import com.healthsciences.services.domain.model.HoursWorkInternship;
import com.healthsciences.services.domain.repositories.IHoursWorkInternRepository;
import com.healthsciences.services.domain.repositories.criteria.BaseSearchCriteria;

@Repository
public class HoursWorkInternshipRepository extends BaseRepository<HoursWorkInternship, BaseSearchCriteria> implements IHoursWorkInternRepository{

}
