package com.global.anagram.io;

import java.util.List;

/**
 * This Interface Diverts Results to Required Output Source
 * @author keval
 *
 */
public interface OutputPrinter {

	/**
	 * Print the Result to implemented source
	 * @param result
	 */
	public void printResult(List<List<String>> result) ;
	
}
