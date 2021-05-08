package com.ashokit.exception;

@SuppressWarnings("serial")
public class NoDataFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2824076919853805265L;
	public NoDataFoundException() {
		
	}
	public NoDataFoundException(String message) {
		super(message);
	}

}
