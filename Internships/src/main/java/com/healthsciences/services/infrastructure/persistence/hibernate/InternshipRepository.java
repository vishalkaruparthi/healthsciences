package com.healthsciences.services.infrastructure.persistence.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.healthsciences.services.domain.model.Internship;
import com.healthsciences.services.domain.repositories.IInternshipRepository;
import com.healthsciences.services.domain.repositories.criteria.BaseSearchCriteria;
import com.healthsciences.services.domain.repositories.criteria.InternshipListCriteria;
import com.healthsciences.services.facade.dto.entities.InternshipDetailsDTO;
import com.healthsciences.services.facade.dto.entities.InternshipsListDTO;

@Repository
public class InternshipRepository extends BaseRepository<Internship, InternshipListCriteria> implements IInternshipRepository {
	
	
	public List<Internship> getInternshipList(InternshipListCriteria listCriteria){
		List<Internship> internshipsList = searchByCriteria(listCriteria);
		return internshipsList;
	}
	
	@Override
	protected List<Predicate> buildConditions(Root<Internship> from, InternshipListCriteria criteria){
		List<Predicate> predicateList = new ArrayList<Predicate>();
		CriteriaBuilder cb = getCriteriaBuilder();
		if(criteria.getStateID()!= null && !"".equals(criteria.getStateID())){
        	predicateList.add(cb.equal(from.get("state").get("stateID"),criteria.getStateID()));
        }
		return predicateList;
	}
}
