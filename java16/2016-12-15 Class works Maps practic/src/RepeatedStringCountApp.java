import java.util.*;
import java.util.Map.Entry;

public class RepeatedStringCountApp {
	private static final String [] STRINGS={"aaaa","aaaa","aaaa","zz","zz","bb","bb","bb","you!"};

	public static void main(String[] args) {
		displayOccurrences(STRINGS);

	}
	
	public static void displayOccurrences(String [] words){
		HashMap<String,Integer> data=new HashMap<>();
		for(String s: words){
			Integer number=data.putIfAbsent(s, 1);
			if (number!=null) data.put(s, number+1);
		}
		
		TreeSet<Entry<String, Integer>> set=new TreeSet<>(new EntryComporator());
		set.addAll(data.entrySet());
		for(Entry<String, Integer> pair: set){
			System.out.println(pair.getKey()+": "+pair.getValue());
		}
	}

}
