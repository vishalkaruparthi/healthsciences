package com.healthsciences.services.infrastructure.persistence.hibernate;

import org.springframework.stereotype.Repository;

import com.healthsciences.services.domain.model.InternshipType;
import com.healthsciences.services.domain.repositories.IInternshipTypeRepository;
import com.healthsciences.services.domain.repositories.criteria.BaseSearchCriteria;

@Repository
public class IntershipTypeRepository extends BaseRepository<InternshipType, BaseSearchCriteria> implements IInternshipTypeRepository{

}
