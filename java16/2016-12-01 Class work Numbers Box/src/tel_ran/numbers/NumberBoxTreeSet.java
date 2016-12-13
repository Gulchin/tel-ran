package tel_ran.numbers;

import java.util.TreeSet;

public class NumberBoxTreeSet extends AbstractNumbersBox {

	public NumberBoxTreeSet() {
		numbers = new TreeSet<>();
	}

	@Override
	public void removeNumbersInRange(int min, int max) {
		TreeSet<Integer> set=(TreeSet<Integer>) numbers;
		set.subSet(min, max+1).clear();
	}

	@Override
	public void removeRepeted() {

	}

	
}
