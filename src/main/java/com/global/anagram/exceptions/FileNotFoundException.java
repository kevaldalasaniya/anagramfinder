package com.global.anagram.exceptions;

import com.global.anagram.exceptions.baseexception.AnagramException;

/**
 * Exception to Handle File Not Found
 * @author keval
 *
 */
public class FileNotFoundException extends AnagramException{

	/**
	 * Default SerialVersion
	 */
	private static final long serialVersionUID = 1L;
	
	public FileNotFoundException(Exception e) {
		super("File Not Found at Provided Path, Please check File Path " + e.getMessage());
	}
}
