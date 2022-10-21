package com.global.anagram.io;

import java.io.IOException;
import java.util.List;

import com.global.anagram.exceptions.FileNotFoundException;
import com.global.anagram.exceptions.baseexception.AnagramException;

/**
 * This Interface Reads Input from Supported Source
 * @author keval
 *
 */
public interface InputReader {

	/**
	 * This Method Reads Input source and return List of Strings
	 * @return
	 * @throws AnagramException 
	 * @throws IOException 
	 */
	public List<String> readInput(long startLine) throws AnagramException, IOException;
}
