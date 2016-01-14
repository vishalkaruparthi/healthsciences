
package com.healthsciences.services.domain.repositories;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.healthsciences.services.domain.model.AbstractEntity;


/**
 * Base repository interface for domain model
 * 
 * 
 * 
 * @param <T>
 */
public interface IBaseRepository<T extends AbstractEntity> {

    /**
     * return max of amount record for select.
     * 
     * @return the row limit
     */
    int getRowLimit();

    /**
     * Save entity to repository.
     * 
     * @param obj
     *            the obj
     */
    void save(T obj);

    /**
     * Remove entity from repository.
     * 
     * @param obj
     *            the obj
     */
    void remove(T obj);

    /**
     * Refresh entity.
     * 
     * @param obj
     *            the obj
     */
    void refresh(T obj);

    /**
     * Get entity from repository.
     * 
     * @param objId
     *            the obj id
     * @return the t
     */
    T get(UUID objId);

    /**
     * Gets the.
     * 
     * @param objId
     *            the obj id
     * @return the t
     */
    T get(Long objId);

    /**
     * Gets the.
     * 
     * @param objId
     *            the obj id
     * @return the t
     */
    T get(Integer objId);

    /**
     * Gets the.
     * 
     * @param objId
     *            the obj id
     * @return the t
     */
    T get(String objId);

    /**
     * Check that set contain entity with define id.
     * 
     * @param set
     *            - set for check
     * @param value
     *            - value to test
     * @return true, if value in set
     */
    boolean valueInSet(Set<T> set, T value);

    /**
     * Get all entities from repository.
     * 
     * @param startIndex
     *            the start index
     * @param pageSize
     *            the page size
     * @param orderField
     *            the order field
     * @return the all
     */
    List<T> getAll(int startIndex, int pageSize, String orderField);

    /**
     * Get total count of entities from repository.
     * 
     * @return the count
     */
    Long getCount();

}
