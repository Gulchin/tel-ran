package tel_ran.numbers.rules;

import tel_ran.numbers.exceptions.WrongNumberException;

public class NumberPrimeRule implements NumberRule {

	private boolean test(Integer t) {
		if (t<2) return false;
		if (t==2||t==3) return true;
		if (t%2==0)return false;
		for(int i=3;i*i<=t&&i*i>0;i+=2){
			if(t%i==0) return false;
		}		
		return true;
	}

	private int getPrimeLarger(int number){
		if (number%2==0) return getPrimeLarger(number+1);
		while (!test(number)) number+=2;		
		return number;
	}

	@Override
	public void matches(int number) throws WrongNumberException {
		if (number<2) throw new WrongNumberException(number, 2-number);
		if (!test(number)) throw new WrongNumberException(number, getPrimeLarger(number)-number);				
	}

}
