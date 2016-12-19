package net.okhotnikov.lists.test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import net.okhotnikov.lists.treeset.AvlTreeSet;

public class AvlTreeSetTest {
	private AvlTreeSet<Integer> set;
	private Integer [] arr={1,3,5,3,4,6,1,-1};
	private Integer [] arrOnAdd={-1,1,3,4,5,6};
	private Integer [] arrDesc={6,5,4,3,1,-1};
	private Integer [] donor={1};
	private Integer [] sub1={1,3,4};
	private Integer [] sub2={1,3,4,5};
	private Integer [] subCleared={-1,5,6};
	private Integer [] subSetRemove1={-1,3,4,5,6};
	private Integer [] subSetRemove2={1,4,5,6};
	private Integer [] headSet3={-1,1,3};
	
	@Before
	public void init(){
		set=new AvlTreeSet<>(null);
		for(int n: arr){
			set.add(n); 
		}
		
	}
	
	@Test
	public void testPrint(){
		System.out.println("******Ptint on add*******");
		set=new AvlTreeSet<>(null);
		for(int n: arr){
			if(set.add(n)) {
			set.print();
			System.out.println("**************");
			}
		}
	}
	
	@Test
	public void testDesdending(){
		assertArrayEquals(arrDesc, set.descendingSet().toArray(donor));
	}
	
	@Test
	public void testAdd(){
		assertArrayEquals(arrOnAdd, set.toArray(donor));
	}
	
	@Test
	public void testGetSubTree(){
		NavigableSet<Integer> subSet=set.subSet(0, true, 5,true);
		assertArrayEquals(sub1,set.subSet(0, 5).toArray(donor));
		assertEquals(new Integer(5), subSet.floor(6));
		assertEquals(new Integer(1), subSet.ceiling(-2));
		assertEquals(new Integer(4), subSet.lower(5));
		assertEquals(new Integer(3), subSet.higher(1));
		assertArrayEquals(sub2,set.subSet(0,true, 5,true).toArray(donor));
	}
	
	@Test
	public void testSubSetClear(){
		set.subSet(0, 5).clear();
		assertArrayEquals(subCleared,set.toArray(donor));
	}
	
	@Test
	public void testSubSetRemove(){		
		set.subSet(0, 5).remove(1);
		assertArrayEquals(subSetRemove1,set.toArray(donor));
	}
	
	@Test
	public void testHeadSet(){
		NavigableSet<Integer> subSet=set.headSet(3,true);
		assertArrayEquals(headSet3, subSet.toArray());
		assertEquals(new Integer(-1), subSet.pollFirst());
		assertEquals(new Integer(3), subSet.pollLast());
		assertArrayEquals(subSetRemove2,set.toArray(donor));

	}
	
	@Test
	public void testRemove(){
		System.out.println("******Remove******");
		for(int n: arr){
			if(set.remove(n)) {
			set.print();
			System.out.println("**************");
			}
		}
	}

}
