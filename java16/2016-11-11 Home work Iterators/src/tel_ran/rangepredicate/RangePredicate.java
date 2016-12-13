package tel_ran.rangepredicate;

import java.util.Iterator;
import java.util.LinkedList;

import tel_ran.rangepredicate.util.NumberPredicate;

public class RangePredicate implements Iterable<Integer> {
	private int min,max;
	private NumberPredicate predicate;
	
	

	public RangePredicate(int min, int max, NumberPredicate predicate) {
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



	public NumberPredicate getPredicate() {
		return predicate;
	}



	@Override
	public Iterator<Integer> iterator() {
		return new RangePredicateIterator(this);
	}
	
	public Integer getFirst(){
		return predicate.getMatcingLargerOrEquel(min);
	}



	public void setPredicate(NumberPredicate predicate) {
		this.predicate = predicate;
	}
	
	public Integer[] getAll(){
		LinkedList<Integer> res=new LinkedList<>();
		for (Integer number:this){
			res.add(number);
		}
		Integer [] arr= new Integer[res.size()]; 
		res.toArray(arr);
		return arr;
	}

}
