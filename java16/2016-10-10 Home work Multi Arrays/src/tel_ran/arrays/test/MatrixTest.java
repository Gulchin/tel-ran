package tel_ran.arrays.test;

import static org.junit.Assert.*;
import static tel_ran.arrays.Matrix.*;

import org.junit.Test;

public class MatrixTest {
	static int[][] arr123={{1,2,3},{4,5,6}};
	static int[][] arr14={{1,4},{2,5},{3,6}};
	static int [][] multRes={{14,32},{32,77}};
	static int [][] arr111={{1,1,1},{1,1,1},{1,1,1}};
	static int [][] multRes2={{6,6,6},{15,15,15}};
	static double [][] initial={{1,2,3},{4,5,4},{3,2,1}};
	static double [][] res={{0.375,-0.5,0.875},{-1,1,-1},{0.875,-0.5,0.375}};
	static double [][] ematrix={{1,0,0},{0,1,0},{0,0,1}};
	static double [] []initial2={{0,1,2},{7,0,3},{6,5,4}};
	static double [][] res2={{-0.25,0.1,0.05},{-0.1666666667,-0.2,0.2333333333},{0.583333333333,0.1,-0.11666666667}};
	static double DELTA=1e-6;

	@Test
	public void testTransp() {
		assertArrayEquals(arr14,transp(arr123));
		assertArrayEquals(arr123,transp(arr14));
		assertArrayEquals(arr111,transp(arr111));
	}
	
	@Test
	public void testSum() {
		assertEquals(21, sum(arr123));
		assertEquals(21, sum(arr14));
		assertEquals(9, sum(arr111));
	}

	@Test
	public void testMultiply() {
		assertArrayEquals(multRes, multiply(arr123, arr14));
		assertArrayEquals(multRes2, multiply(arr123, arr111));
		assertArrayEquals(ematrix, multiply(initial, res));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMultiplyWrongSize() {
		assertArrayEquals(multRes, multiply(arr123, multRes2));
	}
	@Test
	public void testInvers() {
		double [][]actual= inversMatrix(initial);
		for (int i=0;i<initial.length;i++){
		assertArrayEquals(res[i], actual[i],DELTA);
		}
		
		actual= inversMatrix(initial2);
		for (int i=0;i<initial2.length;i++){
		assertArrayEquals(res2[i], actual[i],DELTA);
		}
	}

	
}
