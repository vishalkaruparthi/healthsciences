package com.healthsciences.services.infrastructure.persistence.hibernate;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.healthsciences.services.domain.model.Internship;
import com.healthsciences.services.domain.repositories.IInternshipRepository;
import com.healthsciences.services.domain.repositories.criteria.BaseSearchCriteria;

@Repository
public class InternshipRepository extends BaseRepository<Internship, BaseSearchCriteria> implements IInternshipRepository {

}
