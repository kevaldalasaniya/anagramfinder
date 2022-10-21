package com.global.anagram;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.global.anagram.driver.ApplicationEventListner;

@ActiveProfiles("test")
@SpringBootTest
class AnagramApplicationTests {

	@MockBean
	private ApplicationEventListner applicationEventListner;
	
	@Test
	void contextLoads() {
	}

	
}
