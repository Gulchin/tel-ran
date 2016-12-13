package tel_ran.rangepredicate;

import java.util.Iterator;

import tel_ran.rangepredicate.util.AllNumbers;

public class RangePredicateIterator implements Iterator<Integer> {
	private int current;
	private RangePredicate range;
	
	public RangePredicateIterator(RangePredicate range) {
		super();
		this.range = range;
		//this.current=range.getFirst();
		this.current=range.getMin();
		if(range.getPredicate()==null) range.setPredicate(new AllNumbers());
	}

	@Override
	public boolean hasNext() {
		return current<=range.getMax();
	}

	@Override
	public Integer next() {
		if (!hasNext()) return null;
		int formerCurrent=current;
		//current=range.getPredicate().getMatcingLargerOrEquel(++current);
		current++;
		return formerCurrent;
	}

}
