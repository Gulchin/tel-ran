package tel_ran.rangepredicate.test;

import static org.junit.Assert.*;

import org.junit.Test;

import tel_ran.rangepredicate.RangePredicate;
import tel_ran.rangepredicate.util.AllNumbers;
import tel_ran.rangepredicate.util.EvenPredicate;
import tel_ran.rangepredicate.util.FactorPredicate;
import tel_ran.rangepredicate.util.PrimePredicate;

public class RangePredicateTest {
	private static final RangePredicate simpleRange=new RangePredicate(-5,5,new AllNumbers());
	private static final RangePredicate evenRange=new RangePredicate(-6,6,new EvenPredicate());
	private static final RangePredicate primeRange=new RangePredicate(-5,37,new PrimePredicate());
	private static final RangePredicate factorRange=new RangePredicate(-5,37,new FactorPredicate(4));

	@Test
	public void testPrint() {
		for (Integer n: simpleRange){
			System.out.print(n+" ");
		}
		System.out.println();
		
		for (Integer n: evenRange){
			System.out.print(n+" ");
		}
		System.out.println();
		
		for (Integer n: primeRange){
			System.out.print(n+" ");
		}
		System.out.println();
		
		for (Integer n: factorRange){
			System.out.print(n+" ");
		}
		System.out.println();
	}
	
	@Test
	public void testPredicates(){
		assertTrue(evenRange.getPredicate().test(200));
		assertFalse(evenRange.getPredicate().test(131));
		assertTrue(primeRange.getPredicate().test(104743));
		assertFalse(primeRange.getPredicate().test(50000));
		assertTrue(factorRange.getPredicate().test(8));
		assertFalse(factorRange.getPredicate().test(6));
		
	}
	
	@Test
	public void testRangesWithPredicates(){
		for (Integer number:evenRange){
			assertTrue(number%2==0&&number>=evenRange.getMin()&&number<=evenRange.getMax());
		}
		
		for (Integer number:primeRange){
			assertTrue(primeRange.getPredicate().test(number)&&
					number>=primeRange.getMin()&&number<=primeRange.getMax());
		}
		
		for (Integer number:factorRange){
			assertTrue(factorRange.getPredicate().test(number)&&
					number>=factorRange.getMin()&&number<=factorRange.getMax());
		}
		
	}
	
	@Test
	public void testResultingArray(){
		assertArrayEquals(new Integer[]{-6,-4,-2,0,2,4,6}, evenRange.getAll());

	}

}
