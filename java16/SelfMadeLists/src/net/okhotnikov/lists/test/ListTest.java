package net.okhotnikov.lists.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import net.okhotnikov.lists.LList;


public class ListTest {
	private LList<Integer> list;
	private Integer [] arr={1,3,5,4,-1};
	private Integer [] toarr={1};
	private Integer [] noHead={3,5,4,-1};
	private Integer [] rra={-1,4,5,3,1};
	private ArrayList<Integer> arSubList;
	@Before
	public void init(){
		list=new LList<>();
		for(int n: arr){
			list.add(n);
		}
		arSubList=new ArrayList<>();
		arSubList.add(3);
		arSubList.add(-1);
	}
	
	@Test
	public void testAdd() {
		assertArrayEquals(arr, list.toArray(toarr));
	}
	
	@Test
	public void testRemoveAndSize() {
		assertEquals(arr.length, list.size());
		list.remove();
		assertEquals(noHead.length, list.size());
		assertArrayEquals(noHead, list.toArray(toarr));
		assertEquals(new Integer(5),list.remove(1));
		assertEquals(3, list.size());
		assertArrayEquals(new Integer []{3,4,-1}, list.toArray(toarr));
		assertTrue(list.removeAll(arSubList));
		assertEquals(1, list.size());
		assertArrayEquals(new Integer []{4}, list.toArray(toarr));
		assertFalse(list.remove(new Integer(3)));
		assertTrue(list.remove(new Integer(4)));
		assertArrayEquals(new Integer []{}, list.toArray(toarr));
	}
	
	@Test
	public void testDescendent(){
		Integer [] descArr=new Integer[list.size()];
		Iterator<Integer> it=list.descendingIterator();
		int i=0;
		while(it.hasNext()){
			descArr[i++]=it.next();
		}
		assertArrayEquals(rra,descArr);
		assertFalse(list.removeLastOccurrence(new Integer(66)));
	}
	
	@Test
	public void testFinding(){
		assertEquals(3, list.indexOf(new Integer(4)));
		assertEquals(0, list.indexOf(new Integer(1)));
		assertEquals(4, list.indexOf(new Integer(-1)));
		assertEquals(-1, list.indexOf(new Integer(77)));
		
		assertEquals(3, list.lastIndexOf(new Integer(4)));
		assertEquals(0, list.lastIndexOf(new Integer(1)));
		assertEquals(4, list.lastIndexOf(new Integer(-1)));
		assertEquals(-1, list.lastIndexOf(new Integer(77)));
		
		assertTrue(list.contains(new Integer(4)));
		assertTrue(list.contains(new Integer(1)));
		assertTrue(list.contains(new Integer(-1)));
		
		assertFalse(list.contains(new Integer(99)));
		
		assertTrue(list.containsAll(arSubList));
		arSubList.add(99);
		assertFalse(list.containsAll(arSubList));
	}
	
	@Test
	public void testRetain(){
		assertTrue(list.retainAll(arSubList));
		assertEquals(2, list.size());
		assertArrayEquals(new Integer []{3,-1}, list.toArray(toarr));
	}
	
	


}
