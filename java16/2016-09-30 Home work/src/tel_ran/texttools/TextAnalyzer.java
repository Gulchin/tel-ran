package tel_ran.texttools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextAnalyzer {
	public static int findMaxInt(String text){
		Pattern intPattern=Pattern.compile("-?\\d+");
		Matcher intMatcher=intPattern.matcher(text);
		int maxFound=Integer.MIN_VALUE;
		while(intMatcher.find()){
				int n=Integer.parseInt(intMatcher.group());
				if(n>maxFound) maxFound=n;
		}
		return maxFound;		
	}
	
	public static double findMaxDouble(String text){
		Pattern doublePattern=Pattern.compile("-?\\d+\\.?\\d*");
		Matcher doubleMatcher=doublePattern.matcher(text);
		double maxFound=Double.NEGATIVE_INFINITY;
		while(doubleMatcher.find()){
				double n=Double.parseDouble(doubleMatcher.group());
				if(n>maxFound) {
					maxFound=n;
				}
		}
		return maxFound;		
	}
	
	public static String findLongestWord(String text){
		Pattern wordPattern=Pattern.compile("[A-Za-z]+");
		Matcher wordMatcher=wordPattern.matcher(text);
		String longestFound="";
		while(wordMatcher.find()){
			String s=wordMatcher.group();
			if(s.length()>longestFound.length()){
				longestFound=s;
			}
		}
		return longestFound;
	}

}
