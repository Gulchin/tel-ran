package tel_ran.pictures.util;

import java.util.Iterator;

public class TwoDimItarable<T> implements Iterable<T> {
	Iterable<Iterable<T>> itarable;
	
	public Iterator<Iterable<T>> getOutterIterator(){
		return itarable.iterator();
	}	
	
	public TwoDimItarable(Iterable<Iterable<T>> itarable) {
		super();
		this.itarable = itarable;
	}


	@Override
	public Iterator<T> iterator() {
		return new TwoDimItator<T>(this);
	}

}
