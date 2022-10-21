package com.global.anagram.exceptions.baseexception;

/**
 * Base Exception for all Exceptions for this project
 * @author keval
 *
 */
public class AnagramException extends Exception {

	/**
	 * Default SerialVersion
	 */
	private static final long serialVersionUID = 1L;
	
	public AnagramException(String message) {
		super(message);
	}
	
}
