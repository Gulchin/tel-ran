package net.okhotnikov.testpassword;

import net.okhotnikov.password.PasswordChecker;

public class CheckPasswordTest {
	
	private static final String CONTROL_CHARS="a.c";
	private static final int MIN_PASSWORD_LENGTH=7; 

	public static void main(String[] args) {
		PasswordChecker checker=new PasswordChecker(MIN_PASSWORD_LENGTH,CONTROL_CHARS);
		System.out.println(checker.validatePassword("77t7Gicom"));
	}

}
