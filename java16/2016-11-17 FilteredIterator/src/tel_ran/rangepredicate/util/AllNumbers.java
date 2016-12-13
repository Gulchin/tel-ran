package tel_ran.rangepredicate.util;


public class AllNumbers extends NumberPredicate {

	@Override
	public boolean test(Integer t) {
		return true;
	}

	@Override
	public Integer getMatcingLargerOrEquel(int number) {
		return number;
	}

}
