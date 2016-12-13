package tel_ran.limitedqueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LimitedQueueIterator implements Iterator<Integer> {
	private LimitedQueue queue;
	private int position=0;
		
	public LimitedQueueIterator(LimitedQueue queue) {
		super();
		this.queue = queue;
	}

	@Override
	public boolean hasNext() {
		return position<queue.getSize();
	}

	@Override
	public Integer next() {
		if (!hasNext()) throw new NoSuchElementException();
		return queue.getByIndex(position++);
	}

}
