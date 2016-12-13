package tel_ran.rangepredicate.util;

public class FactorPredicate extends NumberPredicate {
	
	private int divider;
	
	

	public FactorPredicate(int divider) {
		super();
		this.divider = divider;
	}

	@Override
	public boolean test(Integer t) {
		return t%divider==0;
	}

	@Override
	public Integer getMatcingLargerOrEquel(int number) {
		return number+divider-number%divider;
	}

}
