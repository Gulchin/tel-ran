package tel_ran.numbers.test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import tel_ran.numbers.AbstractNumbersBox;
import tel_ran.numbers.NumberBoxTreeSet;
import tel_ran.numbers.NumbersBoxArrayList;
import tel_ran.numbers.NumbersBoxLinkedList;

public class NumbersBoxTest {
	NumbersBoxArrayList arBoxList;
	NumbersBoxLinkedList linkBoxList;
	NumberBoxTreeSet treeBoxList;
	public static  int[] NUMBERS1={3,8,11,20,-33};
    public static  int[] NUMBERS2={3,3,8,11,8,8,20,-33,20};
    public static  int[] NUMBERS3={-33,3,8,11,20};
	
	@Before
	public void init(){
		arBoxList=new NumbersBoxArrayList();
		linkBoxList=new NumbersBoxLinkedList();
		treeBoxList=new NumberBoxTreeSet();
	}

	@Test
	public void testAdd() {
		add(arBoxList);
		add(linkBoxList);
		add(treeBoxList);
	}
	
	void add(AbstractNumbersBox box){
		for(Integer num: NUMBERS1){
			box.add(num);
		}
		int [] arr=new int [box.size()];
		int i=0;
		for(Integer num:box){
			arr[i++]=num;
		}
		if (box instanceof NumberBoxTreeSet) assertArrayEquals(NUMBERS3, arr);
		else 
			assertArrayEquals(NUMBERS1, arr);
	}
	
	@Test
	public void testRemoveEven(){
		removeEven(arBoxList);
		removeEven(linkBoxList);
		removeEven(treeBoxList);
	}
	
	void removeEven(AbstractNumbersBox box){
		for(Integer num: NUMBERS1){
			box.add(num);
		}
		box.removeEvenNumbers();
		int [] arr=new int [box.size()];
		int i=0;
		for(Integer num:box){
			arr[i++]=num;
		}
		if (box instanceof NumberBoxTreeSet)  assertArrayEquals(new int[]{-33,3,11}, arr);
		else 
			assertArrayEquals(new int[]{3,11,-33}, arr);
	}
	
	@Test
	public void testRemoveOdd(){
		removeOdd(arBoxList);
		removeOdd(linkBoxList);
		removeOdd(treeBoxList);
	}
	
	void removeOdd(AbstractNumbersBox box){
		for(Integer num: NUMBERS1){
			box.add(num);
		}
		box.removeOddNumbers();
		int [] arr=new int [box.size()];
		int i=0;
		for(Integer num:box){
			arr[i++]=num;
		}
		assertArrayEquals(new int[]{8,20}, arr);
	}
	
	@Test
	public void testRemoveDuplicate(){
		removeDuplicate(arBoxList);
		removeDuplicate(linkBoxList);
		removeDuplicate(treeBoxList);
	}
	
	void removeDuplicate(AbstractNumbersBox box){
		for(Integer num: NUMBERS2){
			box.add(num);
		}
		box.removeRepeted();
		int [] arr=new int [box.size()];
		int i=0;
		for(Integer num:box){
			arr[i++]=num;
		}
		if (box instanceof NumberBoxTreeSet)  assertArrayEquals(NUMBERS3, arr);
		else 
			assertArrayEquals(NUMBERS1, arr);
	}
	
	@Test
	public void testRemoveRange(){
		removeRange(arBoxList);
		removeRange(linkBoxList);
		removeRange(treeBoxList);
	}
	
	void removeRange(AbstractNumbersBox box){
		for(Integer num: NUMBERS1){
			box.add(num);
		}
		box.removeNumbersInRange(8, 20);;
		int [] arr=new int [box.size()];
		int i=0;
		for(Integer num:box){
			arr[i++]=num;
		}
		if (box instanceof NumberBoxTreeSet)  assertArrayEquals(new int[]{-33,3}, arr);
			else 
		assertArrayEquals(new int[]{3,-33}, arr);
	}
	

}
