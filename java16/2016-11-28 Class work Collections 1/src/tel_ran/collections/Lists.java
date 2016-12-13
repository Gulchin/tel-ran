package tel_ran.collections;

import java.util.*;

public class Lists {

	public static void main(String [] args){
		int [] arr1={-10,15,5,6,20,18,6,2};
		int arr2[]={6,2};
		List<Integer> list1=getList(arr1);
		List<Integer> list2=getList(arr2);
		System.out.println(list1.toString());
		//list1.addAll(list2);
		list1.addAll(3,list2);
		System.out.println(list1);
	//	list1.retainAll(list2);
		//System.out.println(list1.subList(1, 3));
		//list1.removeAll(list1.subList(3, 6));
		//list1.remove(new Integer(6));
		//list1.remove(list1.indexOf(6));
		//removeEven(list1);
		Collection col=list1;
	//	list1.remove(6);
		list1.sort(new EvenComporator());
		System.out.println(list1);
		//list1.removeAll(getList(new int []{6}));
		System.out.println(list1);
	}
	
	private static void removeEven(List<Integer> list) {
//		for(Integer number: list){
//			if(number%2==0) list.remove((Integer)number);
//		}
//		int l=list.size()-1;
//		for (int i=l;i>=0;i--){
//			Integer number=list.get(i);
//			if(number%2==0)list.remove(i);
//		}
		
		Iterator <Integer> it=list.iterator();
		while(it.hasNext()){
			int num=it.next();
			if (num%2==0) it.remove();
		}
	}

	private static List<Integer> getList(int [] numbers){
		List<Integer> result = new ArrayList<>();
		for(int number: numbers){
			result.add(number);
		}
		return result;
	}
}
