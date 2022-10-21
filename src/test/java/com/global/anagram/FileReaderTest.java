package com.global.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.global.anagram.io.impl.FilePathHealper;
import com.global.anagram.io.impl.FileReader;

@SpringBootTest(args = "--file=input.txt")
public class FileReaderTest {
	
	@MockBean
	private FilePathHealper filePathHealper;

	@Autowired
	FileReader fileReader;
	
	/**
	 * Read File in Batches , Words of Same Size at a time
	 */
	@Test
	@DisplayName("Read File")
	void testFileReaderReturnsText() {

		try {
			
			URL res = getClass().getClassLoader().getResource("input.txt");
			File file = Paths.get(res.toURI()).toFile();
			String absolutePath = file.getAbsolutePath();
			
			when(filePathHealper.getFilePath()).thenReturn(absolutePath);
			System.out.println(filePathHealper.getFilePath());
		
			List<String> expactedResultFirstSet = Arrays.asList("abc", "bca", "cza");
			List<String> expactedResultSecondSet = Arrays.asList("abac");
			
			assertEquals(expactedResultFirstSet, fileReader.readInput(0));
			assertEquals(expactedResultSecondSet, fileReader.readInput(3));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
