package com.global.anagram.io.impl;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import com.global.anagram.exceptions.InvalidInputException;
import com.global.anagram.exceptions.baseexception.AnagramException;
import com.global.anagram.io.InputReader;
import com.global.anagram.utils.FileUtils;

import lombok.extern.log4j.Log4j2;

/**
 * Implementation class to Read Words from Text File
 * 
 * @author keval
 *
 */
@Component
@Log4j2
public class FileReader implements InputReader {
	
	@Autowired
	FilePathHealper filePathHealper;

	@Override
	public List<String> readInput(long startLine) throws AnagramException, IOException {

		// Get File Path from Input
		String path = filePathHealper.getFilePath();

		// Perform Validations on File
		validateFile(path);

		// Result where we will store Lines
		List<String> linesToProcess = new ArrayList<String>();

		// Open a Stram to Read File in Chunks as we can see big files in production
		try (Stream<String> lines = Files.lines(Paths.get(path), Charset.defaultCharset())) {

			/*
			 * // Check if File is Empty if (lines.count() == 0) { throw new
			 * EmptyFileException(); }
			 */

			// We will Process Words of Same size at a time so we dont need to keep all
			// words in memory,
			// wordLenght will keep track of lenght of words
			IntWrap wordLenght = new IntWrap();

			// Skip to the Lines we have processed so far
			lines.skip(startLine).forEach(

					entry -> {

						if (wordLenght.getLenght() == 0) {
							wordLenght.setLenght(entry.length());
						}

						// Check if Current Word and Previous Word have same number of caracters then
						// continue
						// else process this words and check back again
						if (entry.length() == wordLenght.getLenght()) {
							linesToProcess.add(entry);
						} else {
							return;
						}
					}

			);

			return linesToProcess;
		} catch (IOException e) {
			log.error("Error In Reading File", e);
			throw e;
		}

	}


	/**
	 * This Method Performs Validations on File
	 * 
	 * @param path
	 * @throws AnagramException
	 * @throws IOException
	 */
	private void validateFile(String path) throws AnagramException, IOException {
		// Check if Path is valid
		if (path.isBlank()) {
			throw new InvalidInputException("File Path is Empty");
		}

		// Check File Type
		FileUtils.checkFileType(path);

		// Check if File is Empty
		FileUtils.checkIfFileEmpty(path);
	}

}

final class IntWrap {
	private int lenght = 0;

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

}