package net.okhotnikov.lists.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import net.okhotnikov.lists.treeset.AvlTreeSet;

public class AvlTreeSetTest {
	private AvlTreeSet<Integer> set;
	private Integer [] arr={1,3,5,3,4,6,1,-1};
	private Integer [] arrOnAdd={-1,1,3,4,5};
//	private Integer [] toarr={1};
//	private Integer [] noHead={3,5,4,-1};
//	private Integer [] rra={-1,4,5,3,1};
	private ArrayList<Integer> arSubList;
	@Before
	public void init(){
		System.out.println("******Add*******");
		set=new AvlTreeSet<>(null);
		for(int n: arr){
			if(set.add(n)) {
			set.print();
			System.out.println("**************");
			}
		}
		
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
