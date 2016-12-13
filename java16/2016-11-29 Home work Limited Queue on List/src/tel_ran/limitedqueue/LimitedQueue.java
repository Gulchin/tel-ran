package tel_ran.limitedqueue;

import java.util.*;

import tel_ran.limitedqueue.exceptions.IdleQueueException;
import tel_ran.limitedqueue.exceptions.RejectQueueException;

public class LimitedQueue implements Iterable<Integer> {
	private int currentSize=0;
	private LinkedList<Integer> elements=new LinkedList<>();
	private int maxSize;
	public static final int  NULL_VALUE=-1;
	

	public LimitedQueue(int maxSize) {
		super();
		this.maxSize=maxSize;
	}

	

	public int getSize() {
		return currentSize;
	}


	protected int getByIndex(int index){
		if (index<0 ||index>=currentSize) throw new IndexOutOfBoundsException();
		return elements.get(index);
	}

	public boolean add(int number) throws RejectQueueException{
		if (isFull()) throw new RejectQueueException();
		if (number<0) return false;
		elements.addLast(number);
		currentSize++;
		return true;
	}

	public int offer(){
		if (currentSize<=0) throw new IdleQueueException();
		currentSize--;
		return elements.removeFirst();
	}
	
	public boolean isFull(){
		return currentSize== maxSize;
	}
	
	public int getMaxSize(){
		return maxSize;
	}
	@Override
	public Iterator<Integer> iterator() {		
		return new LimitedQueueIterator(this);
	}

}
