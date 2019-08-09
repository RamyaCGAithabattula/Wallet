package com.cg.exception;

@SuppressWarnings("serial")
public class ApplicationException extends RuntimeException {
	
	public ApplicationException(String message)
	{
		super(message);
	}

}
