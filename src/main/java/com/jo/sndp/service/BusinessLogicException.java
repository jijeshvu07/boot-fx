/**
 * 
 */
package com.jo.sndp.service;

/**
 * Represents all exceptions that are thrown during a business service operations.
 * This can have sub classes for specific exceptional cases.
 * 
 * @author Shaheer
 * @since Sep 1, 2012
 * @version : 1.0
 * 
 */
public class BusinessLogicException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public BusinessLogicException() {
		super();
	}

	/**
	 * @param message
	 */
	public BusinessLogicException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public BusinessLogicException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BusinessLogicException(String message, Throwable cause) {
		super(message, cause);
	}

}
