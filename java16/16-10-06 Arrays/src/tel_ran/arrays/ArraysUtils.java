package tel_ran.arrays;

import java.util.Arrays;

public class ArraysUtils {
	public static int[]addLast(int [] array, int element){
		int [] result=Arrays.copyOf(array, array.length+1);
		result[array.length]=element;
		return result;
	}

	public static int[]removeByIndex(int [] array, int index){
		if(index<0||index>=array.length) return array;
		int [] result= new int[array.length-1];
		for (int i=0;i<index;i++){
			result[i]=array[i];
		}
		
		for (int i=index+1;i<array.length;i++){
			result[i-1]=array[i];
		}
		
		return result;
	}
	// Предполагаем, что массив отсортирован. Вставить в нужное место
	public static int[]addSortedFor(int [] array, int element){
		int [] result=new int [array.length+1];
		int i=0;
		while (i<array.length && array[i]<element){
			result[i]=array[i];
			i++;
		}
		result[i]=element;
		for (int j=i;j<array.length;j++){
			result[j+1]=array[j];
		}		
		return result;
	}
	
	public static int[]addSorted(int [] array, int element){
		int [] result=new int [array.length+1];
		int index=Arrays.binarySearch(array, element);
		if (index<0) index=-1*index-1;
		System.arraycopy(array, 0, result,0 , index);
		result[index]=element;
		System.arraycopy(array, index, result,index+1 , array.length-index);
		return result;
	}
	
	//Если число существует, нужно его удалить. Если несколько - удалить все
	public static int[]removeSorted(int [] array, int element){
		int index=Arrays.binarySearch(array, element);
		if (index<0) return array;
		int [] result=new int [array.length-1];
		System.arraycopy(array, 0, result,0 , index);
		System.arraycopy(array, index+1, result,index , array.length-index-1);
	
		return removeSorted(result, element);
	}
	
	public static int[]removeSortedFor(int [] array, int element){
		int [] subResult=new int [array.length];
		int finalLength=array.length;
		int i=0;
		while(i<array.length&&array[i]<element){
			subResult[i]=array[i];
			i++;
		}
		
		while(i<array.length&&array[i]==element){
			i++;
			finalLength--;
		}
		
		while(i<array.length){
			subResult[i+finalLength-array.length]=array[i];
			i++;
		}
		return Arrays.copyOf(subResult, finalLength);
	
	}
	
}
