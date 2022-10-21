package com.global.anagram.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.global.anagram.exceptions.EmptyFileException;
import com.global.anagram.exceptions.InvalidInputException;
import com.global.anagram.exceptions.UnsupportedFileTypeException;
import com.global.anagram.exceptions.baseexception.AnagramException;

/**
 * This Class has Utility Methods for File like checking type and others
 * 
 * @author keval
 *
 */
public class FileUtils {

	/**
	 * This Methods Check for File Type
	 * 
	 * @param path
	 * @throws UnsupportedFileTypeException
	 * @throws InvalidInputException
	 */
	public static void checkFileType(String path) throws UnsupportedFileTypeException, InvalidInputException {
		// Check File Content type
		Path filePath = Paths.get(path);
		try {
			String mimeType = Files.probeContentType(filePath);
			if (mimeType != null && !mimeType.contains("text")) {
				throw new UnsupportedFileTypeException(" Input File type is " + mimeType);
			}
		} catch (IOException e1) {
			throw new InvalidInputException("Cannot Determing File Type");
		}
	}

	/**
	 * This Method Check if File is Empty
	 * 
	 * @param path
	 * @throws Exception
	 */
	public static void checkIfFileEmpty(String path) throws AnagramException , IOException {
		try (Stream<String> lines = Files.lines(Paths.get(path), Charset.defaultCharset())) {
			if (lines.count() == 0) {
				throw new EmptyFileException();
			}
		}
	}

}
