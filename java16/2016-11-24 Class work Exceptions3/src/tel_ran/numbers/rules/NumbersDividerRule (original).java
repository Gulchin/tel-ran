package tel_ran.numbers.rules;

import tel_ran.numbers.exceptions.WrongNumberException;

public class NumbersDividerRule implements NumberRule {
 private int divider;

	public NumbersDividerRule(int divider) {
		super();
		this.divider = divider;
	}
	
	public int getDivider() {
		return divider;
	}

	@Override
	public void matches(int number) throws WrongNumberException {
		int remainder=number%divider;
		if (remainder!=0){
			
			int deltaPlus=divider-remainder;
			throw new WrongNumberException(number, remainder < deltaPlus ? -remainder : -deltaPlus);
		}
		
	}
	
 
}
