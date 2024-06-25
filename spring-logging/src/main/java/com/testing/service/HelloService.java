package com.testing.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloService.class);
	
	public void hello() {
		try {
			 riskyOperation();
		} catch (Exception e) {
			logger.error("An error is occur in exception.",e);
		}
	}
	
	 private void riskyOperation() throws Exception {
	        // Example code that throws an exception
	        throw new Exception("Something went wrong");
	    }
}
