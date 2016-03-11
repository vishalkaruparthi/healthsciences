package com.healthsciences.services.infrastructure.persistence.hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.healthsciences.services.domain.model.Internship;
import com.healthsciences.services.domain.repositories.IInternshipRepository;
import com.healthsciences.services.domain.repositories.criteria.BaseSearchCriteria;
import com.healthsciences.services.domain.repositories.criteria.InternshipListCriteria;
import com.healthsciences.services.facade.dto.entities.InternshipDetailsDTO;
import com.healthsciences.services.facade.dto.entities.InternshipsListDTO;

@Repository
public class InternshipRepository extends BaseRepository<Internship, InternshipListCriteria> implements IInternshipRepository {
	
	
	public List<Object> getInternshipList(InternshipListCriteria listCriteria){
		/*
		 * 10 posted_Date desc
		 * 11 posted_Date asc
		 * 
		 * 20 pay_Amount desc
		 * 21 pay_Amount asc
		 * 
		 * 30 organizationName desc
		 * 31 organizationName asc
		 * 
		 *  
		 */
		String orderByQuery = "";
		switch (listCriteria.getSortCriteria()) {
			case 10:
				orderByQuery = "posted_Date desc";
				break;
			case 11:
				orderByQuery = "posted_Date asc";
				break;
			case 20:
				orderByQuery = "pay_Amount desc";
				break;
			case 21:
				orderByQuery = "pay_Amount asc";
				break;
			case 30:
				orderByQuery = "organizationName desc";
				break;
			case 31:
				orderByQuery = "organizationName asc";
				break;
			default:
				orderByQuery = "posted_Date desc";
				break;
		}
		
		@SuppressWarnings("unchecked")
		javax.persistence.Query query = getEntityManager().createQuery("from Internship internship"
				+ " join internship.internshipType internshiptype "
				+ " join internship.hoursWork hoursWork"
				+ " join internship.academicPeriods academicPeriods"
				+ " where internshiptype.internshipType.id not in (:types)"
				+ " and hoursWork.hoursWork.hoursID not in (:hoursWorks)"
				+ " and academicPeriods.academicPeriod.id not in (:academicPeriods)"
				+ " and internship.payType.id = :payTypeID"
				+ " order by internship."+orderByQuery
				);
		
		
		List<Object> internshipsList = query.setParameter("types", listCriteria.getInternType()).setParameter("hoursWorks", listCriteria.getHoursWork())
				.setParameter("academicPeriods", listCriteria.getAcademicPeriod()).setParameter("payTypeID", listCriteria.getPayType())
				.getResultList();
		
		
		return internshipsList;
	}
	
	
	
	
	@Override
	protected List<Predicate> buildConditions(Root<Internship> from, InternshipListCriteria criteria){
		List<Predicate> predicateList = new ArrayList<Predicate>();
		return predicateList;
	}
}
