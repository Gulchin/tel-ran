import java.util.*;
import java.util.Map.Entry;

//ДЗ Энтии Пикче: url string, tags [] string; equals по url конструктор, геттер, ту стинг
// Клас дао с двумя мэпами один по url <String,Picture>
// Второй мэп с ключом таг, а значением список картин с этим тагом <String, List<Picture>>
//similarityPercent int - процент при котором картинки счтиаются похожими (например, при 50%)картинки похожи
//Две функции add - добавить картину. 
// getSimilarPictures - берет массив тагов и дает картинки у которых есть достаточный процент этих тагов.
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
