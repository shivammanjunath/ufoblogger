package com.ufoblogger.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ufoblogger.controller.Login;

public class LoginTest {

	public LoginTest() {
	}
	
	@BeforeClass
	public static void init() {
		
	}

	@Before
	public void setupBefore() {
		
	}
	
	@After
	public void setupAfter() {
		
	}
	
	@Test
	public void testUserLogin() {
		Login userLogin = new Login();
		assertTrue(userLogin.performLogin("Manjunath").toString() != "OK");
	}
}
