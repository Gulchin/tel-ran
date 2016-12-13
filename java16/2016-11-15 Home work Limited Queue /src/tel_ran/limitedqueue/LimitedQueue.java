package tel_ran.limitedqueue;

import java.util.Iterator;

import tel_ran.limitedqueue.exceptions.IdleQueueException;
import tel_ran.limitedqueue.exceptions.RejectQueueException;

public class LimitedQueue implements Iterable<Integer> {
	private int currentSize=0;
	private int [] elements;
	private int head;
	public static final int  NULL_VALUE=-1;
	

	public LimitedQueue(int maxSize) {
		super();
		elements=new int[maxSize];
	}

	

	public int getSize() {
		return currentSize;
	}


	/**
	 * 
	 * @param index - number of an element in the queue
	 * @return real position of an element in the array
	 */
	protected int ringIndex(int index){
		int position=head+index;
		if (position>=elements.length) position-=elements.length;
		return position;
	}
	
	protected int getByIndex(int index){
		if (index<0 ||index>=currentSize) return NULL_VALUE;
		return elements[ringIndex(index)];
	}

	public boolean add(int number) throws RejectQueueException{
		if (isFull()) throw new RejectQueueException();
		if (number<0) return false;
		elements[ringIndex(currentSize++)]=number;
		return true;
	}

	public int offer(){
		if (currentSize<=0) throw new IdleQueueException();
		int res=elements[head++];
		if (head>=elements.length) head=0;
		currentSize--;
		return res;
	}
	
	public int peek(){
		if (currentSize<=0) return NULL_VALUE;
		return elements[head];
	}
	public boolean isFull(){
		return currentSize>= elements.length;
	}
	
	public int getMaxSize(){
		return elements.length;
	}
	@Override
	public Iterator<Integer> iterator() {		
		return new LimitedQueueIterator(this);
	}

}
