package com.jo.sndp.dao;

/**
 * Represents all exceptions that are throw during data access operations.
 * This can have sub classes for specific exceptional cases.
 * 
 * @author Shaheer
 * @since Sep 1, 2012
 * @version : 1.0
 * 
 */
public class DataAccessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public DataAccessException() {
		super();
	}

	/**
	 * @param message
	 */
	public DataAccessException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public DataAccessException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

}
