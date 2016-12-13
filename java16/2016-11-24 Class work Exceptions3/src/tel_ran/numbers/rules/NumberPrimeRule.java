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
	
	private int getPrimeSmaller(int number){
		if (number%2==0) return getPrimeSmaller(number-1);
		while (!test(number)) {
			number-=2;	
			if(number<2) throw new IllegalArgumentException();
		}
		return number;
	}

	@Override
	public void matches(int number) throws WrongNumberException {
		if (number<2) throw new WrongNumberException(number, 2-number);
		if (!test(number)) {
			int primeSmaller;
			int primeLarger=getPrimeLarger(number);
			try{
				primeSmaller=getPrimeSmaller(number);
				throw new WrongNumberException(number,
						number-primeSmaller<primeLarger-number ?
						 primeSmaller -number : primeLarger-number);
			} catch(IllegalArgumentException e){
				throw new WrongNumberException(number, primeLarger-number);		
			}
			
			
		}
	}

}
