package tel_ran.numbers.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import tel_ran.numbers.exceptions.WrongNumberException;
import tel_ran.numbers.generators.RandomNaturalNumbersGenerator;
import tel_ran.numbers.rules.NumberPrimeRule;
import tel_ran.numbers.rules.NumbersDividerRule;
// Дз найти ближайшее число
public class RandomNaturalNumbersGeneratorTest {
	
	private static final RandomNaturalNumbersGenerator generator=new RandomNaturalNumbersGenerator(5,
			new NumbersDividerRule(5));
	private static final RandomNaturalNumbersGenerator generatorPrime=new RandomNaturalNumbersGenerator(5,
			new NumberPrimeRule());
	private static final int [] dividerNumbers={555,45,5,1000};
	private static final int [] nonDividerNumbers={554,43,11,1008};
	private static final int [] primeNumbers={37,5,17,179424871};
	private static final int [] nonPrimeNumbers={1,4,20,179424872};

	@Test
	public void printTest() {
		System.out.println(Arrays.toString(generator.generate()));
		System.out.println(Arrays.toString(generatorPrime.generate()));
	}
	
	@Test 
	public void ruleTest() throws WrongNumberException{
		for(int i=0;i<dividerNumbers.length;i++){
			generator.getRule().matches(dividerNumbers[i]);
		}
		for(int i=0;i<primeNumbers.length;i++){
			generatorPrime.getRule().matches(primeNumbers[i]);
		}
	}
	@Test 
	public void ruleTestWrongNumbers() {
		for(int i=0;i<nonDividerNumbers.length;i++){
			try{
			generator.getRule().matches(nonDividerNumbers[i]);
			fail("number: " + nonDividerNumbers[i]+" goes throgh mathces");
			} catch (WrongNumberException e){
				
			}
		}
		
		for(int i=0;i<nonPrimeNumbers.length;i++){
			try{
			generatorPrime.getRule().matches(nonPrimeNumbers[i]);
			fail("number: " + nonPrimeNumbers[i]+" goes throgh mathces");
			} catch (WrongNumberException e){
				
			}
		}
	}
	
	@Test
	public void generateTest() throws WrongNumberException {
		int [] array=generator.generate();
		for (int i=0;i<array.length;i++){
			generator.getRule().matches(array[i]);
			
		}
		
		array=generatorPrime.generate();
		for (int i=0;i<array.length;i++){
			generatorPrime.getRule().matches(array[i]);
		}
		
	}
	

}
