package tel_ran.calculations.tests;
// импортирует статические методы. Можно использовать методы, без указания имени класса
import static org.junit.Assert.*;
import static tel_ran.calculations.Calculator.*;

import org.junit.Test;

import tel_ran.calculations.Calculator;

public class CalculatorTest {

	@Test
	public void testSum() {
		assertEquals(7, Calculator.sum(3, 4));
		assertEquals(8, Calculator.sum(4, 4));
	}
	@Test
	public void testMul() {
		assertEquals(8, multiply(2, 4));
		assertEquals(16, multiply(4, 4));
	}

	@Test
	public void testSub() {
		assertEquals(8, substruct(10, 2));
		assertEquals(0, substruct(4, 4));
	}
	
	@Test
	public void testDev() {
		for (int i=0; i<100; i++){
		assertEquals(5, devide(10, 2));
		assertEquals(1, devide(4, 4));
		}
	}
}
