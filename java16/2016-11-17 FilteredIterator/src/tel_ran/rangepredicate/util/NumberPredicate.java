package tel_ran.rangepredicate.util;

import java.util.function.Predicate;

public abstract class NumberPredicate implements Predicate<Integer> {
	public abstract Integer getMatcingLargerOrEquel(int number);

}
