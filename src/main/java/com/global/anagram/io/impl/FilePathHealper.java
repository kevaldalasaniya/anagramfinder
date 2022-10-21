package com.global.anagram.io.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/**
 * This Class Help to find File from Coomandline Arguments
 * @author keval
 *
 */
@Component
public class FilePathHealper {

	@Autowired
	ApplicationArguments applicationArguments;
	
	/**
	 * Get File Path from Arguments
	 * 
	 * @return
	 */
	public String getFilePath() {
		// Get File Path from Input
		String path = applicationArguments.getOptionValues("file").get(0);
		return path;
	}
}
