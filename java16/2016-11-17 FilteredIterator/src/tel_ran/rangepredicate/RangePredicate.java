package tel_ran.rangepredicate;

import java.util.Iterator;
import java.util.function.Predicate;

import tel_ran.filterediterator.FilteredIterator;

public class RangePredicate implements Iterable<Integer> {
	private int min,max;
	private Predicate<Integer> predicate;
		
	public RangePredicate(int min, int max, Predicate<Integer>  predicate) {
		super();
		this.min = min;
		this.max = max;
		this.predicate = predicate;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}


	public Predicate<Integer>  getPredicate() {
		return predicate;
	}


	@Override
	public Iterator<Integer> iterator() {
		return new FilteredIterator<Integer>(new RangePredicateIterator(this),predicate);
	}
	
//	public Integer getFirst(){
//		return predicate.getMatcingLargerOrEquel(min);
//	}

	public void setPredicate(Predicate<Integer>  predicate) {
		this.predicate = predicate;
	}

}
