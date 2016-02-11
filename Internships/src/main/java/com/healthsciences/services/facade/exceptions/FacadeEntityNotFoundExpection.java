package com.healthsciences.services.facade.exceptions;

import java.io.Serializable;

public class FacadeEntityNotFoundExpection extends Exception{
	private static final long serialVersionUID = 1L;

	private final Class<?> clazz;
	
	private final Serializable id;
    /**
     * Contructor.
     * 
     * @param clazz
     *            the clazz
     * @param id
     *            the id
     */
    public FacadeEntityNotFoundExpection(Class<?> clazz, Serializable id) {
    	this.id = id;
    	this.clazz = clazz;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return "Entity " + clazz.getSimpleName() + " #" + id.toString()
        + " hasn't been found.";
    }
}
