package tel_ran.arrays.test;

import static org.junit.Assert.*;
import static tel_ran.arrays.ArraysUtils.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ArraysUtilsTest {
	static int [] speedTestRes,speedTestArr;
	public static final int TEST_LENGTH=1000000;
	public static final int REPEATS=1000;
	public static final int OFFSET=1000;
	
	@BeforeClass
	public static void prepareArray(){
		speedTestRes=new int[TEST_LENGTH-REPEATS];
		speedTestArr=new int[TEST_LENGTH];
		for(int i=0;i<TEST_LENGTH;i++){
			
			if(i<OFFSET){
				speedTestRes[i]=i;
				speedTestArr[i]=i;
			} else if (i<OFFSET+REPEATS){
				speedTestArr[i]=OFFSET;				
			} else {
				speedTestArr[i]=i;
				speedTestRes[i-REPEATS]=i;
			}
		}	
	}

	@Test
	public void testAddLast() {
		int [] array={1,2,3};
		int [] result ={1,2,3,5};
		assertArrayEquals(result, addLast(array,5));
	}
	
	@Test
	public void testRemove() {
		int [] result={1,2,3};
		int [] array ={1,2,3,5};
		assertArrayEquals(result, removeByIndex(array,3));
		
		int [] result2={1,2,5};
		int [] array2 ={1,2,3,5};
		assertArrayEquals(result2, removeByIndex(array2,2));
	}
	
	@Test
	public void testAddSorted() {
		int [] array={1,2,3};
		int [] result ={1,2,3,5};
		assertArrayEquals(result, addSorted(array,5));
			
		int [] array2={1,2,5};
		int [] result2 ={1,2,3,5};
		assertArrayEquals(result2, addSorted(array2,3));
	}
	
	@Test
	public void testAddSortedFor() {
		int [] array={1,2,3};
		int [] result ={1,2,3,5};
		assertArrayEquals(result, addSortedFor(array,5));
			
		int [] array2={1,2,5};
		int [] result2 ={1,2,3,5};
		assertArrayEquals(result2, addSortedFor(array2,3));
	}
	
	@Test
	public void testRemoveSorted() {
		int [] array={1,2,3,5};
		int [] result ={1,3,5};
		assertArrayEquals(result, removeSorted(array,2));
		
		int [] array1={1,2,2,3,5};
		int [] result1 ={1,3,5};
		assertArrayEquals(result1, removeSorted(array1,2));
			
		int [] array2={1,2,3,5};
		int [] result2 ={2,3,5};
		assertArrayEquals(result2, removeSorted(array2,1));
		
		assertArrayEquals(speedTestRes, removeSorted(speedTestArr,OFFSET));
	}
	
	@Test
	public void testRemoveSortedFor() {
		int [] array={1,2,3,5};
		int [] result ={1,3,5};
		assertArrayEquals(result, removeSortedFor(array,2));
		
		int [] array1={1,2,2,3,5};
		int [] result1 ={1,3,5};
		assertArrayEquals(result1, removeSortedFor(array1,2));
			
		int [] array2={1,2,3,5};
		int [] result2 ={2,3,5};
		assertArrayEquals(result2, removeSortedFor(array2,1));	

		assertArrayEquals(speedTestRes, removeSortedFor(speedTestArr,OFFSET));
	}

}
