package com.global.anagram.exceptions;

import com.global.anagram.exceptions.baseexception.AnagramException;

/**
 * This Exception Handles Invalid Inputs like Path Not Found 
 * @author keval
 *
 */
public class InvalidInputException extends AnagramException {

	/**
	 * Default SerialVersion
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidInputException(String msg) {
		super("Invalid Input : " + msg);
	}
}
