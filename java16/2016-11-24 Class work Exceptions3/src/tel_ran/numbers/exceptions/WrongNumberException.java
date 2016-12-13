package tel_ran.numbers.exceptions;

import tel_ran.numbers.rules.NumberRule;

public class WrongNumberException extends Exception {
	private int number,fixingNumber;

	public WrongNumberException(int number, int fixingNumber) {
		super();
		this.number = number;
		this.fixingNumber = fixingNumber;
	}

	public int getNumber() {
		return number;
	}

	public int getFixingNumber() {
		return fixingNumber;
	}
	
}
