package tel_ran.numbers;

import tel_ran.numbers.excepsion.LessThanMinException;
import tel_ran.numbers.excepsion.GreaterThanMaxException;

public class RangeExceptions {
	
	private int min,max;

	public RangeExceptions(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}
	
	public void check(int number) throws LessThanMinException, GreaterThanMaxException {
		if (number<min)
			throw new LessThanMinException();
		if (number>max) 
			throw new GreaterThanMaxException();
	}
	
	public int getRandom(){
		return (int)(Math.random()*(max-min+1))+min;
	}

}
