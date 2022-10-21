package com.global.anagram.services;

import java.util.List;

/**
 * This Interface Takes Strings as Input and Give List of Anagrams
 * @author keval
 *
 */
public interface AnagramFinder {

	/**
	 * Find Anagrams from Given List of Input Words
	 * @param words
	 * @return
	 */
	public List<List<String>> findAnagrams(List<String> words) ;
}
