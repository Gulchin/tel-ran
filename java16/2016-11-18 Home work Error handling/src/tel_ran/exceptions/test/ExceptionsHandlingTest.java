package tel_ran.exceptions.test;

import static org.junit.Assert.*;
import static tel_ran.exceptionhandling.NumberChecker.*;

import java.util.function.Predicate;

import org.junit.Test;

import tel_ran.exceptionhandling.MemoryAlocator;
import tel_ran.exceptionhandling.MaximumMatchingSearcher;
import tel_ran.exceptionhandling.Range;

public class ExceptionsHandlingTest {

	private static final String TEN = "10";
	private static final String POLTORA = "1.5";
	private static final String NE_CHISLO = "some letters";
	int memoryResult=-1;

	@Test
	public void testNumberCheckers() {
		assertTrue(isNumber(TEN));
		assertTrue(isInteger(TEN));
		assertTrue(isNumber(POLTORA));
		assertFalse(isInteger(POLTORA));
		assertFalse(isInteger(NE_CHISLO));
		assertFalse(isNumber(NE_CHISLO));
		assertTrue(isNumber(".11e10"));
	}
	
	@Test
	public void simpleSearcherTest(){
		MaximumMatchingSearcher searcher=new MaximumMatchingSearcher(new Range(1,111),new Predicate<Integer>(){

			@Override
			public boolean test(Integer t) {
				return t<111;
			}
			
		});
		assertEquals(110,searcher.find());
		
	}
//	@Test
//	public void memoryTest(){
//		MaximumMatchingSearcher searcher=new MaximumMatchingSearcher(new Range(1,Integer.MAX_VALUE),
//				new MemoryAlocator());
//		memoryResult=searcher.find();
//		System.out.println("Found value: "+memoryResult);
//	}

	@Test(expected = OutOfMemoryError.class )
	public void outOfMemoryTest(){
		MaximumMatchingSearcher searcher=new MaximumMatchingSearcher(new Range(1,Integer.MAX_VALUE),
				new MemoryAlocator());
		memoryResult=searcher.find();
		System.out.println("Found value: "+memoryResult);
		byte [] arr=new byte[memoryResult+1];
		arr=null;
	}
}
