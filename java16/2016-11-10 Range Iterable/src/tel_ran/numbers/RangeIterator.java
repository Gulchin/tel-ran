package tel_ran.numbers;

import java.util.Iterator;

public class RangeIterator implements Iterator<Integer> {
	private int current;
	private Range range;
	
	

	public RangeIterator(Range range) {
		super();
		this.current = range.getMin();
		this.range = range;
	}

	@Override
	public boolean hasNext() {
		return current<=range.getMax();
	}

	@Override
	public Integer next() {
		return current++;
	}

	@Override
	public void remove() {
		range.setMax(range.getMax()-1);
	}

	
}
