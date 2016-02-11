package com.healthsciences.services.facade.exceptions;

import java.io.Serializable;

public class FacadeUnknownException extends Exception{
	private static final long serialVersionUID = 1L;


    public FacadeUnknownException(String message){
    	super(message);
    }
    
}
