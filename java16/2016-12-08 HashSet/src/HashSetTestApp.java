import java.util.*;

public class HashSetTestApp {
	//Дз добавить в намебр бокс еще LinkedHashSet. Сделать перформенс тесты с многократным повторением на большом объеме
	// Вывести результаты для разных коллекций
	public static void main(String [] arrgs){
//		String str="Vasya1";
//		System.out.println(str.hashCode());
//		HashSet<Integer> set=new HashSet<>();
//		set.add(16);
//		set.add(32);
//		set.add(64);
//		set.add(128);
//		set.add(256);
//		set.add(512);
//		set.add(1024);
		HashSet<String> set=new HashSet<>();
		for(int i=0;i<12;i++){
			set.add("Name"+i);
		}
		set.add("the end");
		for (String s: set){
			System.out.println(s);
		}
	}

}
