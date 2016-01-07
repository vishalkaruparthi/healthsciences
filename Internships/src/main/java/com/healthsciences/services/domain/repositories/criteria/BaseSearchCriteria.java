/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.healthsciences.services.domain.repositories.criteria;


public abstract class BaseSearchCriteria {
    private String orderField;
    private String orderType;
    private Integer startIndex;
    private Integer pageSize;
    private String groupBy;
	private boolean returnCount = false;

	public String getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}

    /**
     * Gets the order field.
     * 
     * @return the order field
     */
    public String getOrderField() {
        return orderField;
    }

    /**
     * Sets the order field.
     * 
     * @param orderField
     *            the order field
     */
    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    /**
     * Gets the start index.
     * 
     * @return the start index
     */
    public Integer getStartIndex() {
        return startIndex;
    }

    /**
     * Sets the start index.
     * 
     * @param startIndex
     *            the start index
     */
    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    /**
     * Gets the page size.
     * 
     * @return the page size
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Sets the page size.
     * 
     * @param pageSize
     *            the page size
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Checks if is return count.
     * 
     * @return true, if checks if is return count
     */
    public boolean isReturnCount() {
        return returnCount;
    }

    /**
     * Sets the return count.
     * 
     * @param returnCount
     *            the return count
     */
    public void setReturnCount(boolean returnCount) {
        this.returnCount = returnCount;
    }

    /**
     * Gets the order type.
     * 
     * @return the order type
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * Sets the order type.
     * 
     * @param orderType
     *            the order type
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

}
