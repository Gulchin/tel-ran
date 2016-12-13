package tel_ran.maps;

import java.util.*;

public class MapTestApp {

	public static void main(String[] args) {
		//Map<Integer,String> map=new LinkedHashMap<>();
		Map<Integer,String> map=new TreeMap<>();
		map.put(10, "october");
		map.put(11, "november");
		map.put(5, "may");
		map.put(8, "august");
		map.put(3, "march");
		map.put(1, "january");
		map.put(6, "june");
		map.put(7, "july");
		
		for(int n:map.keySet()){
			System.out.println(n);
		}
		
		for(String n:map.values()){
			System.out.println(n);
		}
		
		for (Map.Entry<Integer, String> pair: map.entrySet()){
			System.out.println(pair);
			System.out.println(pair.getKey()+"->"+pair.getValue());
		}
		
		for(int i=0;i<5;i++){
			System.out.println(map.get((int)(1+Math.random()*12)));
		}
		String oldMarch=map.put(3, "MAR");
		System.out.println("key 3 old value: "+oldMarch+", new value: "+map.get(3));
	}

}
