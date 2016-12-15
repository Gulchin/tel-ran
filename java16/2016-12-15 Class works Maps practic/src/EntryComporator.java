import java.util.Comparator;
import java.util.Map.Entry;

public class EntryComporator implements Comparator<Entry<String,Integer>> {

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		int val1=o1.getValue();
		int val2=o2.getValue();
//		if (val1!=val2) return val2-val1;
//		return o1.getKey().compareTo(o2.getKey());
		
		return val1!=val2 ? val2-val1 :o1.getKey().compareTo(o2.getKey());
	}

}
