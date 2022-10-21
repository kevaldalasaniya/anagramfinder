package com.global.anagram.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * This Class will called when Application will be started
 * 
 * @author keval
 *
 */
@Component
public class ApplicationEventListner {

	@Autowired
	AnagramFinderDriver anagramFinderDriver;

	@EventListener(ApplicationReadyEvent.class)
	public void startAlgo() {
		System.out.println("--- Starting Application ---");
		anagramFinderDriver.findAnagrams();
	}
}
