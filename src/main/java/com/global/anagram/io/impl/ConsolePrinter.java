package com.global.anagram.io.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.global.anagram.io.OutputPrinter;

/**
 * This Class Prints Generated Anagrams on console
 * 
 * @author keval
 *
 */
@Component
public class ConsolePrinter implements OutputPrinter {

	@Override
	public void printResult(List<List<String>> result) {

		result.stream().forEach(System.out::println);

	}

}
