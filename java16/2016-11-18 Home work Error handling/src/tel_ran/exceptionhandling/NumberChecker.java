package tel_ran.exceptionhandling;

public class NumberChecker {
	public static boolean isNumber(String str){
		try{
			Double.parseDouble(str);
			return true;
		} catch (Throwable e){
			return false;
		}
	}
	
	public static boolean isInteger(String str){
		try{
			Integer.parseInt(str);
			return true;
		} catch (Throwable e){
			return false;
		}
	}

}
