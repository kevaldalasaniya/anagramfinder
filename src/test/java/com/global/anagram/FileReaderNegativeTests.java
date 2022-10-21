package com.global.anagram;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.global.anagram.exceptions.EmptyFileException;
import com.global.anagram.exceptions.UnsupportedFileTypeException;
import com.global.anagram.io.impl.FileReader;
import com.global.anagram.utils.FileUtils;

/**
 * This Class Has Negative Tests For File Reader
 * @author keval
 *
 */
@SpringBootTest(args = "--file=D://dummy")
public class FileReaderNegativeTests {

	@Autowired
	FileReader fileReader;

	/**
	 * Test to check File Type
	 */
	@Test
	@DisplayName("Test for File Type Check")
	void whenInvalidFileType_throwException() {

		try {
			Path path = Files.createTempFile("test-file", ".mp4");
			Throwable exception = assertThrows(UnsupportedFileTypeException.class,
					() -> FileUtils.checkFileType(path.toString()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Return True for Text File
	 */
	@Test
	@DisplayName("Test for Valid File Type")
	void whenFileTypeText_doesNotThrowException() {

	 try {
			Path path = Files.createTempFile("test-file", ".txt");
			assertDoesNotThrow(() -> FileUtils.checkFileType(path.toString()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * Test for Empty File
	 */
	@Test
	@DisplayName("Test for Empty File Check")
	void whenFileEmpty_throwException() {

		FileUtils fileUtils = new FileUtils();

		try {
			Path path = Files.createTempFile("test-file", ".txt");
			Throwable exception = assertThrows(EmptyFileException.class,
					() -> fileUtils.checkIfFileEmpty(path.toString()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * Test Exception Handling for File Not Found
	 */
	@Test
	@DisplayName("Check for Exception when File not Found")
	void whenFileNotFound_throwException() {

		Throwable exception = assertThrows(IOException.class, () -> fileReader.readInput(0));
		System.out.println(exception.getMessage());
		assertEquals("D:\\dummy", exception.getMessage());

	}
	
}
