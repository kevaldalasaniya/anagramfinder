package com.global.anagram.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.global.anagram.services.AnagramFinder;

/**
 * Implementation Class for AnagramFinderImpl
 * How this Algorithm Works :
 *  1. First We will sort Input String so string for example like bcaq will be abcq , due to sorting 
 *  strings with same characters will became same like acbq will also be abcq
 *  2. Then We will Check in Map If We Already have Key for this word
 *  3. If we finds key then add it against list in value as all these values are anagram
 * @author keval
 *
 */
@Component
public class AnagramFinderImpl implements AnagramFinder {

	@Override
	public List<List<String>> findAnagrams(List<String> words) {
		
		// This Map will hold Words and their Anagrams so far founded
		 HashMap<String, List<String>> anagrams = new HashMap<>();

		 // Iterate Through Each Words
	        for (int i = 0; i < words.size(); i++) {
	        	
	            String word = words.get(i);
	            
	            // Sort Input Word
	            char[] wordAsArray = word.toCharArray();
	            Arrays.sort(wordAsArray);
	           // Converting Sorted Char array to String
	            String sortedWord = new String(wordAsArray);

	            // Check if we already have this word else add blank list againts it
	            if (!anagrams.containsKey(sortedWord)) {
	            	anagrams.put(sortedWord, new ArrayList<>());
	            }
	            
	            // Here we will add original string against sorted key 
	            anagrams.get(sortedWord).add(word);
	        }
	        
	        // Return All values
	        return new ArrayList<>(anagrams.values());

	}

}
