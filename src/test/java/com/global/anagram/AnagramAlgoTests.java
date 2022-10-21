package com.global.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.global.anagram.services.AnagramFinder;

/**
 * Test Anagram Algorithm
 * @author keval
 *
 */
@SpringBootTest
public class AnagramAlgoTests {

	@Autowired
	AnagramFinder anagramFinder;

	@Test
	void testAnagramAlgo() {

		List<String> input1 = Arrays.asList("abc", "cba");
		List<String> input2 = Arrays.asList("abc", "cz");
		List<String> input3 = Arrays.asList("abc%", "%cba");
		
		List<List<String>> input1Result = Arrays.asList( Arrays.asList( "abc", "cba"));
		List<List<String>> input2Result = Arrays.asList( Arrays.asList( "abc") , Arrays.asList("cz"));
		List<List<String>> input3Result = Arrays.asList( Arrays.asList( "abc%", "%cba"));
		
		assertEquals(input1Result, anagramFinder.findAnagrams(input1));
		assertEquals(input2Result, anagramFinder.findAnagrams(input2));
		assertEquals(input3Result, anagramFinder.findAnagrams(input3));
		
		
		
	}

}
