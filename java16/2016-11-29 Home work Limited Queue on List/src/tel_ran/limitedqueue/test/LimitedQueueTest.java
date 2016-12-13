package tel_ran.limitedqueue.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;

import tel_ran.limitedqueue.LimitedQueue;
import tel_ran.limitedqueue.exceptions.IdleQueueException;
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
		for (int i=0;i<NUMBERS6.length-1;i++){
				assertTrue(queue.add(NUMBERS6[i]));
		}
		
		try{
			queue.add(NUMBERS6[NUMBERS6.length-1]);
			fail("Must have exception");
		} catch (RejectQueueException e){
			
		}
		int fromQueue;
		for (int i=0;i<NUMBERS6.length-1;i++){
			fromQueue=queue.offer();	
				assertEquals(NUMBERS6[i], fromQueue);

		}	
		try{
			queue.offer();
			fail("Must have exception");
		} catch (IdleQueueException e){
			
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
	


}
