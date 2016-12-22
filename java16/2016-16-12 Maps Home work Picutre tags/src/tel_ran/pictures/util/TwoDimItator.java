package tel_ran.pictures.util;

import java.util.Iterator;

public class TwoDimItator<T> implements Iterator<T> {
	Iterator<Iterable<T>> outterIterator;
	Iterator<T> innerIterator=null;
	boolean isEmpty;

	public TwoDimItator(TwoDimItarable<T> itarable) {
		outterIterator=itarable.getOutterIterator();
		if(outterIterator.hasNext())
			innerIterator=outterIterator.next().iterator();
		else isEmpty=true;
	}

	@Override
	public boolean hasNext() {
		if (isEmpty) return false;
		return outterIterator.hasNext()||innerIterator.hasNext();
	}

	@Override
	public T next() {
		if (innerIterator.hasNext()) return innerIterator.next();
		innerIterator=outterIterator.next().iterator();
		return innerIterator.next();
	}

}
