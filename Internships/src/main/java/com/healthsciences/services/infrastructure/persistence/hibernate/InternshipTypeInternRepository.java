package com.healthsciences.services.infrastructure.persistence.hibernate;

import org.springframework.stereotype.Repository;

import com.healthsciences.services.domain.model.InternshiptypeInternship;
import com.healthsciences.services.domain.repositories.IInternshipTypeInternRepo;
import com.healthsciences.services.domain.repositories.criteria.BaseSearchCriteria;

@Repository
public class InternshipTypeInternRepository extends BaseRepository<InternshiptypeInternship, BaseSearchCriteria> implements IInternshipTypeInternRepo{

}
