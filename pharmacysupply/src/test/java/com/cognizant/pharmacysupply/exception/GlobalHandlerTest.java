package com.cognizant.pharmacysupply.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GlobalHandlerTest {
	
	@Autowired
	private GlobalHandler globalHandler;
	
	@Test
	public void testHandleAllErrors() throws Exception {	
		assertEquals(HttpStatus.NOT_FOUND,	globalHandler.handleAllErrors(new Exception()).getStatusCode());
	}
	
	
}
