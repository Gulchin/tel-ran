package tel_ran.exceptionhandling;

import java.util.Iterator;
import java.util.function.Predicate;

public class MaximumMatchingSearcher implements Iterable<Range> {
	private Range range;
	private Predicate<Integer> predicate;
	
	
	
	public MaximumMatchingSearcher(Range range, Predicate<Integer> predicate) {
		super();
		this.range = range;
		this.predicate = predicate;
	}



	public Range getRange() {
		return range;
	}



	public Predicate<Integer> getPredicate() {
		return predicate;
	}

	public int find(){
		if (predicate.test(range.getMax())) return range.getMax();
		if (!predicate.test(range.getMin())){
			throw new IllegalArgumentException("Condition must be satisfied at the begining of the range");
		}
		Range res=null;
		for (Range range:this){
			res=range;
		}
		return res.getMiddle();
	}

	@Override
	public Iterator<Range> iterator() {
		return new CloseIterator(this);
	}

}
