package net.okhotnikov.password;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {
	private int minLength;
	private String controlChars;//control char can be non alphanumerical
	

	public PasswordChecker(int maxLength, String controlChars) {
		this.minLength = maxLength;
		this.controlChars = controlChars;
	}
	
	public boolean validatePasswordRegex(String password){
		int length=password.length();
		if (length<minLength) return false;
		 //If find not allowed symbol
        if(Pattern.compile(String.format("[^A-Za-z\\d%s]",controlChars)).matcher(password).find()){
        	System.out.println("Find illegal symbol");
        	return false;
        }
        	
	
		Pattern lowerCasePattern=Pattern.compile("[a-z]");
		Pattern upperCasePattern=Pattern.compile("[A-Z]");
		Pattern digitPattern=Pattern.compile("\\d");
        Pattern controlCharsPattern=Pattern.compile(String.format("[%s]",controlChars));

        Matcher controlCharsMatcher = controlCharsPattern.matcher(password);
        Matcher lowerCaseMatcher=lowerCasePattern.matcher(password);
        Matcher upperCaseMatcher=upperCasePattern.matcher(password);
        Matcher digitMatcher=digitPattern.matcher(password);       

		return lowerCaseMatcher.find()&&upperCaseMatcher.find()&&digitMatcher.find()&&controlCharsMatcher.find();
	}
	
	public boolean validatePassword(String password){
		int length=password.length();
		if (length<minLength) return false;
		boolean foundControlChar=false;
		boolean foundUpperCase=false;
		boolean foundLowerCase=false;
		boolean foundDigit=false;
		for (int i=0;i<length;i++){
			char c=password.charAt(i);
			if(!Character.isLetterOrDigit(c)) {			
				if (controlChars.contains(String.valueOf(c))){
					foundControlChar=true;
				} else return false;
			} 
			else
			{			
				if (controlChars.contains(String.valueOf(c))){
					foundControlChar=true;
				}			
				if (Character.isDigit(c)) {
					foundDigit=true;
				} else if(Character.isUpperCase(c)){
					foundUpperCase=true;
				} else {
					foundLowerCase=true;
			}			
		}
		}
		return foundDigit&&foundUpperCase&&foundLowerCase&&foundControlChar;
	
	}
}
