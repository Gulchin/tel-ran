package tel_ran.numbers.util;
import java.util.function.Predicate;

public class EvenPredicate implements Predicate<Integer> {

	
	public EvenPredicate() {
	}

	@Override
	public boolean test(Integer t) {
		return t%2==0;
	}

}
