package net.okhotnikov.testpassword;

import static org.junit.Assert.*;

import org.junit.Test;

import net.okhotnikov.password.PasswordChecker;

public class TestCheckPassword {
	
	@Test
	public void testRegex() {
		String CONTROL_CHARS=".,";
		int MIN_PASSWORD_LENGTH=7;
		PasswordChecker checker= new PasswordChecker(MIN_PASSWORD_LENGTH,CONTROL_CHARS);
 
		assertEquals(false,checker.validatePasswordRegex("7t7Gicom"));
		assertEquals(false,checker.validatePasswordRegex("7t.%7Gicom"));
		assertEquals(true,checker.validatePassword("7t,7Gicom"));
		assertEquals(false,checker.validatePasswordRegex("7A7G88999"));
		assertEquals(false,checker.validatePasswordRegex("7A7G88999".toLowerCase()));
		assertEquals(false,checker.validatePassword("Ac5"));
		
		CONTROL_CHARS="a5";
		MIN_PASSWORD_LENGTH=6;
		checker= new PasswordChecker(MIN_PASSWORD_LENGTH,CONTROL_CHARS);

		assertEquals(true,checker.validatePasswordRegex("7t5Gicom"));
		assertEquals(true,checker.validatePassword("Acaaa5"));
		assertEquals(false,checker.validatePassword("Aca.aa5"));
	}
	@Test
	public void testFor() {
		
		String CONTROL_CHARS=".,";
		int MIN_PASSWORD_LENGTH=7;
		PasswordChecker checker= new PasswordChecker(MIN_PASSWORD_LENGTH,CONTROL_CHARS);
 
		assertEquals(false,checker.validatePassword("7t7Gicom"));
		assertEquals(false,checker.validatePassword("7t.%7Gicom"));
		assertEquals(true,checker.validatePassword("7t,7Gicom"));
		assertEquals(false,checker.validatePasswordRegex("7A7G88999"));
		assertEquals(false,checker.validatePasswordRegex("7A7G88999".toLowerCase()));
		assertEquals(false,checker.validatePassword("Ac5"));
		
		CONTROL_CHARS="a5";
		MIN_PASSWORD_LENGTH=6;
		checker= new PasswordChecker(MIN_PASSWORD_LENGTH,CONTROL_CHARS);

		assertEquals(true,checker.validatePasswordRegex("7t5Gicom"));
		assertEquals(true,checker.validatePassword("Acaaa5"));
		assertEquals(false,checker.validatePassword("Aca.aa5"));
	}

}
