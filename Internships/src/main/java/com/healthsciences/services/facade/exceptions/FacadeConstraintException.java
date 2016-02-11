/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.healthsciences.services.facade.exceptions;


/**
 * Thrown when attempting an action that violates a constraint
 */
public class FacadeConstraintException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * The Constructor.
     * 
     * @param message
     *            the message
     */
    public FacadeConstraintException(String message) {
        super(message);
    }

    /**
     * The Constructor.
     * 
     * @param message
     *            the message
     * @param cause
     *            the cause
     */
    public FacadeConstraintException(String message, Throwable cause) {
        super(message, cause);
    }
}
