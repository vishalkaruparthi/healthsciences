package com.healthsciences.services.infrastructure.persistence.hibernate;

import org.springframework.stereotype.Repository;

import com.healthsciences.services.domain.model.HoursWork;
import com.healthsciences.services.domain.repositories.IHoursWorkRepository;
import com.healthsciences.services.domain.repositories.criteria.BaseSearchCriteria;
@Repository
public class HoursWorkRepository extends BaseRepository<HoursWork, BaseSearchCriteria> implements IHoursWorkRepository{

}
