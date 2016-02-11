/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.healthsciences.services.facade.exceptions;


/**
 * Exception for wrong credentials
 */
public class FacadeBadCredentialsException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * The Constructor.
     * 
     * @param message
     *            the message
     * @param cause
     *            the cause
     */
    public FacadeBadCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * The Constructor.
     * 
     * @param message
     *            the message
     */
    public FacadeBadCredentialsException(String message) {
        super(message);
    }
}
