package tel_ran.calculations;

public class Calculator {
	public static int multiply(int op1, int op2){
		return op1*op2;
	}

	public static int sum(int op1, int op2){
		return op1+op2;
	}
	public static int devide(int op1, int op2){
		if (op2==0) return Integer.MAX_VALUE;
		return op1/op2;
	}
	public static int substruct(int op1, int op2){
		return op1-op2;
	}
}
