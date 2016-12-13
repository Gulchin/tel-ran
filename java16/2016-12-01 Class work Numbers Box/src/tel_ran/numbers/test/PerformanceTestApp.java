package tel_ran.numbers.test;

import tel_ran.numbers.NumberBoxLinkedHashSet;
import tel_ran.numbers.NumberBoxPerformanceTest;
import tel_ran.numbers.NumberBoxTreeSet;
import tel_ran.numbers.NumbersBoxArrayList;
import tel_ran.numbers.NumbersBoxLinkedList;
import tel_ran.numbers.interfaces.INumberBox;

public class PerformanceTestApp {

	private static final int NNUMBERS = 100000;
	private static final int NREPEATS = 10000;
	private static final INumberBox [] BOXES = {new NumbersBoxArrayList(), new NumbersBoxLinkedList(),
			new NumberBoxLinkedHashSet(), new NumberBoxTreeSet()};

	public static void main(String[] args) {
		System.out.println("\t|ArrayList|\tLinkedlist|\tLinkedHashSet|\t   Treeset|");
		NumberBoxPerformanceTest test= new NumberBoxPerformanceTest(NNUMBERS, NREPEATS);
		System.out.print("Contains      |");
		for(INumberBox box: BOXES){
			test.setBox(box);
			long res=test.testContains();
			System.out.print("\t"+res+"|\t");
		}
		System.out.println();
		System.out.print("Remove        |");
		for(INumberBox box: BOXES){
			test.setBox(box);
			long res=test.testRemove();
			System.out.print("\t"+res+"|\t");
		}
		System.out.println();
		System.out.print("RemoveOdd     |");
		for(INumberBox box: BOXES){
			test.setBox(box);
			long res=test.testRemoveOdd();
			System.out.print("\t"+res+"|\t");
		}
		
		System.out.println();
		System.out.print("RemoveRange   |");
		for(INumberBox box: BOXES){
			test.setBox(box);
			long res=test.testRemoveRange();
			System.out.print("\t"+res+"|\t");
		}
		
		System.out.println();
		System.out.print("RemoveRepeated|");
		for(INumberBox box: BOXES){
			test.setBox(box);
			long res=test.testRemoveRepeated();
			System.out.print("\t"+res+"|\t");
		}
	}

}
