package tel_ran.multiarrays;

import java.util.Arrays;

public class ArraysTest {

	public static void main(String[] args) {
		int []array={1,-10,3,40};
		int array2[]={1,100};
		int []array3={10,20,80};
		int array4[]=array3;
		array3[1]=50;
		System.out.println(Arrays.toString(array4));
		int[][]arr22={array,array2,array3,array4,{10}};
	//	System.out.println(Arrays.toString(new int[]{10}));
		System.out.println(Arrays.deepToString((arr22)));
		arr22[2][1]=99;
		System.out.println(Arrays.deepToString((arr22)));
		System.out.println(arr22[4].length);
		
		//int [][]arr11=new int[][8];Не правильно
		int [][]arr11=new int[8][]; //Допустимо
		System.out.println(Arrays.deepToString((arr11)));
		int [][]arr00={{1,2},{2,3,4},{10,90,-1}};
		System.out.println(Arrays.deepToString((arr00)));
		Arrays.sort(arr00[2]);
		System.out.println(Arrays.deepToString((arr00)));
	}

}
