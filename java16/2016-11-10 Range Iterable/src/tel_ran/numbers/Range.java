package tel_ran.numbers;

import java.util.Iterator;

public class Range implements Iterable<Integer> {
	private int min,max;
	
	
	
	public Range(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}



	public int getMin() {
		return min;
	}



	public int getMax() {
		return max;
	}



	public void setMax(int max) {
		this.max = max;
	}



	@Override
	public Iterator<Integer> iterator() {
		return new RangeIterator(this);
	}

}
