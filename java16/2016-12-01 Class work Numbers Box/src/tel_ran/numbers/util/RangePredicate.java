package tel_ran.numbers.util;

import java.util.function.Predicate;

public class RangePredicate implements Predicate<Integer> {
	private int min,max;
	
	public RangePredicate(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean test(Integer t) {
		return t>= min&& t<=max;
	}

}
