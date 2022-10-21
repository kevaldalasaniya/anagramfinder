package com.global.anagram.exceptions;

import com.global.anagram.exceptions.baseexception.AnagramException;

/**
 * Exception to Handle Empty File
 * @author keval
 *
 */
public class EmptyFileException extends AnagramException{

	/**
	 * Default SerialVersion
	 */
	private static final long serialVersionUID = 1L;
	
	public EmptyFileException() {
		super("Passed File is Empty so cannot run program, please check input file");
	}
}
