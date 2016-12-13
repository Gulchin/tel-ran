package tel_ran.rangepredicate.util;


public class EvenPredicate extends NumberPredicate {

	@Override
	public boolean test(Integer t) {
		return t%2==0;
	}


	@Override
	public Integer getMatcingLargerOrEquel(int number) {
		return test(number) ? number : number+1;
	}

}
