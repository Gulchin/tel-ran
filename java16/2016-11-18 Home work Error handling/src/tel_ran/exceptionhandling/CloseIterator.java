package tel_ran.exceptionhandling;

import java.util.Iterator;

public class CloseIterator implements Iterator<Range> {
	private MaximumMatchingSearcher searcher;
	private Range current;
	

	public CloseIterator(MaximumMatchingSearcher searcher) {
		super();
		this.searcher = searcher;
		current=searcher.getRange();
	}

	@Override
	public boolean hasNext() {
		return !current.isMinimum();
	}

	@Override
	public Range next() {
		Range res=current;
		int middle=current.getMiddle();
		System.out.println("Searching in the range{ min:"+current.getMin()+" middle: "+ middle + " max: " +current.getMax()+"}");
		if (searcher.getPredicate().test(middle)){
			current=new Range(middle,current.getMax());
		} else {
			current=new Range(current.getMin(),middle);
		}
		return res;
	}

}
