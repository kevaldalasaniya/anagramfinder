package com.global.anagram.exceptions;

import com.global.anagram.exceptions.baseexception.AnagramException;

/**
 * Exception if Input file is not containing text like MP3 or MP4
 * @author keval
 *
 */
public class UnsupportedFileTypeException extends AnagramException {

	/**
	 * Default SerialVersion
	 */
	private static final long serialVersionUID = 1L;
	
	public UnsupportedFileTypeException(String msg) {
		super("Input File Is Not Text File, Please Pass File That Contains Text " + msg);
	}

}
