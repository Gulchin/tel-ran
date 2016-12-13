package tel_ran.numberstest;

import static org.junit.Assert.*;

import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;

import tel_ran.numbers.Range;
import tel_ran.numbers.RangeIterator;

public class TestRange {
	private static final int MIN = 10;

	private static final int MAX = 12;

	Range numbers=new Range(10,12);
	
	Range range;

	
	@Test
	public void iterationTest(){
//		for(int i=0;i<numbers.length;i++){
//			assertTrue(numbers[i]>=MIN&&numbers[i]<=MAX);
//		}
		
		for(Integer n:numbers){
			assertTrue(n>=MIN&&n<=MAX);
		}
	}

	@Before
	public void setup(){
		range=new Range(7,77);
	}
	
	@Test
	public void testRange() {
		for(Integer n:range){
			System.out.print(n+" ");
		}
		System.out.println();
	}
	
	@Test
	public void testWhile(){
		RangeIterator iterator=(RangeIterator)range.iterator();
		while(iterator.hasNext()){
			
			System.out.print(iterator.next()+" ");
			iterator.remove();
		}
		System.out.println();
	}
	
	@Test
	public void testForEach(){
		RangeIterator iterator=(RangeIterator)range.iterator();
		while(iterator.hasNext()){
			
			System.out.print(iterator.next()+" ");
			iterator.forEachRemaining(new Consumer<Integer>(){

				@Override
				public void accept(Integer t) {
					t++;
					System.out.print(t+" ");
				}
				
			});
		}
	}

}
