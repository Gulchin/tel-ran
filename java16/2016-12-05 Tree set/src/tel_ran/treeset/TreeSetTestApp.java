package tel_ran.treeset;
import java.util.*;

public class TreeSetTestApp {
//Дз написать класс NumbersBoxTreeSet унаследованный от абстрактного намбербокса. В этом класее 
//переписать некоторые функции, чтобы было оптимально с использование TreeSet
	public static void main(String[] args) {
		int nnumbers=100000;
		int nrepeats=100000;
		TreeSet<Integer> set=new TreeSet<>();
//		ArrayList<Integer> alist=new ArrayList<>();
//		LinkedList<Integer> llist=new LinkedList<>();
		int [] arr={3,1,7,-20,100,50,80};
		fillCollection(set,arr);
				//getRandomNumbers(nnumbers, 1, Integer.MAX_VALUE));
//		fillCollection(alist,
//				getRandomNumbers(nnumbers, 1, Integer.MAX_VALUE));
//		fillCollection(llist,
//				getRandomNumbers(nnumbers, 1, Integer.MAX_VALUE));
		
//		System.out.println("set :"+getRunTime(set, nrepeats));
//		System.out.println("alist :"+getRunTime(alist, nrepeats));
//		System.out.println("llist :"+getRunTime(llist, nrepeats));
//		System.out.println(set.first());
		System.out.println(set.headSet(7));
		System.out.println(set.tailSet(7));
		System.out.println(set.subSet(7, 50));
		System.out.println(set.subSet(7, 51));
		System.out.println(set.ceiling(6));
		System.out.println(set.ceiling(101));
		System.out.println(set.floor(3));
		System.out.println(set.subSet(7,true, 50,true));
		System.out.println(set.subSet(7,false, 50,true));
		System.out.println(set);
		ArrayList<Integer> arrl=new ArrayList<>(set.subSet(7, 51));
		set.removeAll(arrl);
		System.out.println(set);

	}
	
	static long getRunTime(Collection<Integer> col, int nrepeats){
		long startTime=System.currentTimeMillis();
		for(int i=0;i<nrepeats; i++){
			col.contains(42);
		}
		
		long endTime=System.currentTimeMillis();
		return endTime-startTime;
	}
	
	private static void fillCollection(Collection<Integer> col,int [] array ){
		for(int number: array){
			col.add(number);
		}
	}
	
	static int [] getRandomNumbers(int nnumbers,int min, int max){
		Random gen=new Random();
		int [] result= new int [nnumbers];
		for(int i=0;i<nnumbers;i++){
			result[i]=min+gen.nextInt(max-min+1);
		}
		return result;
	}

}
