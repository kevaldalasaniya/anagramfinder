package com.global.anagram.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.global.anagram.exceptions.baseexception.AnagramException;
import com.global.anagram.io.InputReader;
import com.global.anagram.io.OutputPrinter;
import com.global.anagram.services.AnagramFinder;

import lombok.extern.log4j.Log4j2;

/**
 * This class which will Drive Whole Application
 * @author keval
 *
 */
@Component
@Log4j2
public class AnagramFinderDriver {

	@Autowired
	InputReader inputReader;
	
	@Autowired
	AnagramFinder anagramFinder;
	
	@Autowired
	OutputPrinter outputPrinter;
	
	/**
	 * Entry point to start Finding Anagrams,
	 * This Method will Read Words of Same size at a time , applies algorithm on it and prints it so that 
	 * we dont need to hold entire file in memory
	 */
	
	public void findAnagrams() {
		
		try {
		    // Read Words of Same Size from the file, iterate through file until we reach end of file 
			for(int startCount =0;;) {
				List<String> words = inputReader.readInput(startCount);
				
				// If words are empty then we have reached end of file
				if(words.isEmpty()) {
					break;
				}
				
				log.info("Processing words with size : {}",words.get(0).length());
				// We will pass this words to our Anagram Finder Algorithm and Get the Result
				List<List<String>> result = anagramFinder.findAnagrams(words);
				
				
				// We got the result now need to print it 
				outputPrinter.printResult(result);
				
				// As we have readed first batch increase startCount to size of batch
				startCount = startCount+words.size();
				
			}
			
			System.out.println("--- End Of Algorithm ---");
		}
		catch(AnagramException e) {
			log.error("AnagramException Caught with reason {} ", e.getMessage(),e);
			System.out.println("Cannot Proceed With Execation Due to " + e.getMessage());
		}
		catch (Exception e) {
			log.error("Unexpected Exception Occured", e.getMessage(),e);
			System.out.println("Cannot Proceed With Execation Due to " + e.getMessage());
		}
	}
	
}
