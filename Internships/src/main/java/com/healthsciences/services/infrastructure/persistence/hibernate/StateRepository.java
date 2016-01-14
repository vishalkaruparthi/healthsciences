package com.healthsciences.services.infrastructure.persistence.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthsciences.services.domain.model.State;
import com.healthsciences.services.domain.repositories.IStateRepository;
import com.healthsciences.services.domain.repositories.criteria.BaseSearchCriteria;
@Repository
public class StateRepository extends BaseRepository<State, BaseSearchCriteria> implements IStateRepository{


}
