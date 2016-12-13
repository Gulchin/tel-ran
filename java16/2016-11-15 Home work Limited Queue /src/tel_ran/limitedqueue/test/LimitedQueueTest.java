package tel_ran.limitedqueue.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;

import tel_ran.limitedqueue.LimitedQueue;
import tel_ran.limitedqueue.exceptions.RejectQueueException;

public class LimitedQueueTest {
	LimitedQueue queue=new LimitedQueue(5);
	private static final int[] NUMBERS6= {10,20,30,40,50,60};
	private static final int[] NUMBERS5= {10,20,30,40,50};
	private static final int[] NUMBERS4= {10,20,30,40};
	private static final int[] NUMBERS3= {10,20,30};
	private static final int[] NUMBERS2= {10,20};
	private static final int[] NUMBERS1= {10};
	private static final int [][] ITERATIONS_UP={NUMBERS1,NUMBERS2,NUMBERS3,NUMBERS4,NUMBERS5};
	private static final int [][] ITERATIONS_DOWN={{20,30,40,50},{30,40,50},{40,50},{50},{}};

	@Test
	public void testAddOffer() throws RejectQueueException {
		for (int i=0;i<NUMBERS6.length;i++){
			if (i<NUMBERS6.length-1)
				assertTrue(queue.add(NUMBERS6[i]));
			else 
				assertFalse(queue.add(NUMBERS6[i]));
		}
		int fromQueue;
		for (int i=0;i<NUMBERS6.length;i++){
			fromQueue=queue.offer();
			if (i<NUMBERS6.length-1)
				assertEquals(NUMBERS6[i], fromQueue);
			else 
				assertEquals(LimitedQueue.NULL_VALUE, fromQueue);
		}		
	}
	
	@Test
	public void testIterator() throws RejectQueueException{
		int [] fromQueue;
		for (int i=0;i<NUMBERS5.length;i++){
			queue.add(NUMBERS5[i]);
			fromQueue= new int [queue.getSize()];
			int index=0;
			for (Integer number:queue){
				fromQueue[index++]=number;
			}
			assertArrayEquals(ITERATIONS_UP[i], fromQueue);
			System.out.println(Arrays.toString(fromQueue));
		}
		
		for (int i=0;i<ITERATIONS_DOWN.length;i++){
			queue.offer();
			fromQueue= new int [queue.getSize()];
			int index=0;
			for (Integer number:queue){
				fromQueue[index++]=number;
			}
			assertArrayEquals(ITERATIONS_DOWN[i], fromQueue);
			System.out.println(Arrays.toString(fromQueue));
		}							
	}
	
	@Test
	public void testNegative() throws RejectQueueException{
		assertFalse(queue.add(-1));
	}
	
	@Test
	public void testIntegrity() throws RejectQueueException{
		Iterator<Integer> iterator=queue.iterator();

		for (int i=0;i<NUMBERS6.length;i++){
				queue.add(NUMBERS6[i]);
				if (i!=NUMBERS6.length-1)
					assertEquals(NUMBERS6[i], (int)iterator.next());
				else{
					assertEquals(LimitedQueue.NULL_VALUE, (int)iterator.next());
					assertFalse(iterator.hasNext());
				}
		}
		
		iterator=queue.iterator();
		
		for (int i=0;i<NUMBERS5.length;i++){
			queue.offer();
			
			if (i<NUMBERS5.length/2)
				assertEquals(NUMBERS5[i*2+1], (int)iterator.next());
			else{
				assertEquals(LimitedQueue.NULL_VALUE, (int)iterator.next());
			}
		}
	}


}
