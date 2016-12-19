package net.okhotnikov.lists.treeset;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class FilteredIterator<T> implements Iterator<T> {
	private Iterator<T> iterator;
	private Predicate<T> predicate;
	private T current;
	private boolean hasNext;
	
	public FilteredIterator(Iterator<T> iterator, Predicate<T> predicate) {
		super();
		this.iterator = iterator;
		this.predicate = predicate;
		iterateToMatching();
	}
	
	private void iterateToMatching(){
		hasNext=false;
		do{
				hasNext=iterator.hasNext();
				if (!hasNext){
					current=null;
					return;
				}
				current=iterator.next();
			} while (!predicate.test(current));
	}
	
	@Override
	public boolean hasNext() {
		return hasNext;
	}
	@Override
	public T next() {
		if (!hasNext) throw new NoSuchElementException();
		T res=current;
		iterateToMatching();
		return res;
	}
	

}
