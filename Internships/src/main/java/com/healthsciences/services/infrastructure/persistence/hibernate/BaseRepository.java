
package com.healthsciences.services.infrastructure.persistence.hibernate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Value;

import com.healthsciences.services.domain.model.AbstractEntity;
import com.healthsciences.services.domain.repositories.IBaseRepository;
import com.healthsciences.services.domain.repositories.criteria.BaseSearchCriteria;



/**
 * Base repository for all domain models
 * 
 * @author mkol
 * 
 * @param <T>
 * @param <E>
 */
public abstract class BaseRepository<T extends AbstractEntity, E extends BaseSearchCriteria>
        implements IBaseRepository<T> {
    @PersistenceContext
    private EntityManager em;

    private CriteriaBuilder builder;

    @Value("${infrastructure.persistence.rowLimit}")
    private int rowLimit;

    @SuppressWarnings("rawtypes")
    private Class entityClass;

    /*
     * (non-Javadoc)
     * 
     * @see com.kony.es.repositories.IBaseRepository#getRowLimit()
     */
    public int getRowLimit() {
        return rowLimit;
    }

    /**
     * Gets the entity manager.
     * 
     * @return the entity manager
     */
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Gets the criteria builder.
     * 
     * @return the criteria builder
     */
    protected CriteriaBuilder getCriteriaBuilder() {
        return (builder != null) ? builder : em.getCriteriaBuilder();
    }

    /**
     * Gets the entity class.
     * 
     * @return the entity class
     */
    @SuppressWarnings({ "unchecked" })
    protected synchronized Class<T> getEntityClass() {

        if (entityClass == null) {
            Type type = getClass().getGenericSuperclass();
            loop: while (true) {
                if (type instanceof ParameterizedType) {
                    Type[] arguments = ((ParameterizedType) type)
                            .getActualTypeArguments();
                    for (Type argument : arguments) {
                        if (argument instanceof Class
                                && AbstractEntity.class
                                        .isAssignableFrom(((Class<T>) argument))) {
                            entityClass = (Class<T>) argument;
                            break loop;
                        }
                    }
                }
                type = ((Class<?>) type).getGenericSuperclass();
                if (type == Object.class) {
                    throw new RuntimeException(
                            "Could not find a DatabaseObject subclass parameterized type");
                }
            }
        }
        return entityClass;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.kony.es.repositories.IBaseRepository#save(com.abharana.services.domain
     * .model .AbstractEntity)
     */
    public void save(T obj) {
        em.persist(obj);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.kony.es.repositories.IBaseRepository#remove(com.abharana.services.domain
     * .model .AbstractEntity)
     */
    public void remove(T obj) {
        em.remove(obj);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.kony.es.repositories.IBaseRepository#refresh(com.abharana.services.domain
     * .model .AbstractEntity)
     */
    public void refresh(T obj) {
        em.getEntityManagerFactory().getCache().evictAll();
        em.refresh(obj);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.kony.es.repositories.IBaseRepository#get(java.util.UUID)
     */
    public T get(UUID objId) {
        em.flush();
        return em.find(getEntityClass(), objId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.kony.es.repositories.IBaseRepository#get(String)
     */
    public T get(String objId) {
        em.flush();
        return em.find(getEntityClass(), objId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.kony.es.repositories.IBaseRepository#get(Long)
     */
    public T get(Long id) {
        em.flush();
        return em.find(getEntityClass(), id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.kony.es.repositories.IBaseRepository#get(Integer)
     */
    public T get(Integer id) {
        em.flush();
        return em.find(getEntityClass(), id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.kony.es.repositories.IBaseRepository#valueInSet(Set<T> set, T
     * value)
     */
    public boolean valueInSet(Set<T> set, T value) {
        boolean result = false;

        for (Iterator<T> it = set.iterator(); it.hasNext();) {
            if (it.next().getId().equals(value.getId())) {
                result = true;
                break;
            }
        }
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.kony.es.repositories.IBaseRepository#getAll(int, int,
     * java.lang.String)
     */

    public List<T> getAll(int startIndex, int pageSize, String orderField) {
        CriteriaQuery<T> query = getCriteriaBuilder().createQuery(
                getEntityClass());
        Root<T> from = query.from(getEntityClass());
        query.select(from);

        if (orderField != null) {
            query.orderBy(getCriteriaBuilder().asc(from.get(orderField)));
        }

        TypedQuery<T> typedQuery = getEntityManager().createQuery(query);

        if (pageSize > 0) {
            typedQuery.setFirstResult(startIndex);
            typedQuery.setMaxResults(pageSize);
        } else {
            typedQuery.setFirstResult(0);
            typedQuery.setMaxResults(rowLimit);
        }
        return typedQuery.getResultList();

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.kony.es.repositories.IBaseRepository#getCount()
     */
    public Long getCount() {
        return searchByCriteriaCount(null);
    }

    /**
     * Builds the conditions.
     * 
     * @param from
     *            the from
     * @param criteria
     *            the criteria
     * @return the list< predicate>
     */
    protected List<Predicate> buildConditions(Root<T> from, E criteria) {
        return Collections.emptyList();
    }

    /**
     * Search by criteria.
     * 
     * @param criteria
     *            the criteria
     * @return the list< t>
     */
    protected List<T> searchByCriteria(E criteria) {
        CriteriaQuery<T> query = getCriteriaBuilder().createQuery(
                getEntityClass());
        Root<T> from = query.from(getEntityClass());
        query.select(from);
        List<Predicate> predicateList = buildConditions(from, criteria);
        if (predicateList != null) {
            Predicate[] predicates = new Predicate[predicateList.size()];
            predicateList.toArray(predicates);
            query.where(predicates);
        }
        if(criteria.getGroupBy()!=null){
        	query.groupBy(from.get(criteria.getGroupBy()));
        }
        if (criteria.getOrderField() != null) {
            if (criteria.getOrderType() != null
                    && !"".equals(criteria.getOrderType())) {
                StringTokenizer outerTokenizer = new StringTokenizer(
                        criteria.getOrderField(), ",");
                StringTokenizer typeTokenizer = new StringTokenizer(
                        criteria.getOrderType(), ",");
                List<Order> orders = new ArrayList<Order>();
                while (outerTokenizer.hasMoreElements()) {
                    String field = (String) outerTokenizer.nextElement();
                    String type = (String) typeTokenizer.nextElement();
                    Path ex = null;
                    if (field.indexOf(".") > 0) {
                        StringTokenizer tokenizer = new StringTokenizer(field,
                                ".");
                        while (tokenizer.hasMoreElements()) {
                            String key = (String) tokenizer.nextElement();
                            if (ex == null) {
                                ex = from.get(key);
                            } else {
                                ex = ex.get(key);
                            }
                        }
                    } else {
                        ex = from.get(field);
                    }
                    if ("desc".equals(type)) {
                        orders.add(getCriteriaBuilder().desc(ex));
                    } else if ("asc".equals(type)) {
                        orders.add(getCriteriaBuilder().asc(ex));
                    }
                }
                if (orders.size() > 0) {
                    query.orderBy(orders);
                }
            } else {
                query.orderBy(getCriteriaBuilder().desc(
                        from.get(criteria.getOrderField())));
            }
        }

        TypedQuery<T> typedQuery = getEntityManager().createQuery(query);
        if (criteria.getStartIndex() != null) {
            typedQuery.setFirstResult(criteria.getStartIndex());
            typedQuery.setMaxResults(criteria.getPageSize());
        } else {
            typedQuery.setFirstResult(0);
            typedQuery.setMaxResults(rowLimit);
        }
        System.out.println("dfjdfjdkfdkfjd"+typedQuery.toString());
        return typedQuery.getResultList();
    }

    /**
     * Search by criteria count.
     * 
     * @param criteria
     *            the criteria
     * @return the long
     */
    protected Long searchByCriteriaCount(E criteria) {
        CriteriaQuery<Long> query = getCriteriaBuilder()
                .createQuery(Long.class);
        Root<T> from = query.from(getEntityClass());
        query.select(getCriteriaBuilder().count(from));

        if (criteria != null) {
            List<Predicate> predicateList = buildConditions(from, criteria);
            if (predicateList != null) {
                Predicate[] predicates = new Predicate[predicateList.size()];
                predicateList.toArray(predicates);
                query.where(predicates);
            }
        }

        return getEntityManager().createQuery(query).getSingleResult();
    }

    /**
     * Gets the single result.
     * 
     * @param result
     *            the result
     * @return the single result
     */
    protected T getSingleResult(List<T> result) {
        return ((result == null) || (result.size() == 0)) ? null : result
                .get(0);
    }

    /**
     * Gets the single result.
     * 
     * @param q
     *            the q
     * @return the single result
     */
    protected T getSingleResult(CriteriaQuery<T> q) {
        T obj;
        try {
            obj = getEntityManager().createQuery(q).getSingleResult();
        } catch (NoResultException e) {
            obj = null;
        }

        return obj;
    }

    /**
     * Gets the result list.
     * 
     * @param q
     *            the q
     * @return the result list
     */
    protected List<T> getResultList(CriteriaQuery<T> q) {
        List<T> list;
        try {
            list = getEntityManager().createQuery(q).getResultList();
        } catch (NoResultException e) {
            list = null;
        }

        return list;
    }

    /**
     * Gets the result list with limit.
     * 
     * @param q
     *            the q
     * @param noOfRecords
     *            the no of records
     * @return the result list with limit
     */
    protected List<T> getResultListWithLimit(CriteriaQuery<T> q, int noOfRecords) {
        List<T> list;
        try {
            TypedQuery<T> typedQuery = getEntityManager().createQuery(q);
            typedQuery.setFirstResult(0);
            typedQuery.setMaxResults(noOfRecords);
            list = typedQuery.getResultList();
        } catch (NoResultException e) {
            list = null;
        }

        return list;
    }
}
