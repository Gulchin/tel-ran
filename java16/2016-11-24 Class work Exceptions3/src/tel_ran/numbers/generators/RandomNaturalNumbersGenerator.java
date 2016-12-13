package tel_ran.numbers.generators;

import tel_ran.numbers.exceptions.WrongNumberException;
import tel_ran.numbers.rules.NumberRule;

public class RandomNaturalNumbersGenerator {
	private int size;
	private NumberRule rule;


	public RandomNaturalNumbersGenerator(int size, NumberRule rule) {
		super();
		this.size = size;
		this.rule = rule;
	}


	public int[] generate(){
		int [] res= new int [size];
		for (int i=0; i<res.length;i++){
			try{
				int number=getRandom();
				rule.matches(number);
				res[i]=number;
			}catch(WrongNumberException e){
				res[i]=e.getNumber()+e.getFixingNumber();
			}
		}
		return res;
	}
	
	private int getRandom(){
		return 1+(int)(Math.random()*Integer.MAX_VALUE);

	}


	public int getSize() {
		return size;
	}


	public NumberRule getRule() {
		return rule;
	}
	
}
