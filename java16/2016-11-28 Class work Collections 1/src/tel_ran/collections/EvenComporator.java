package tel_ran.collections;

import java.util.Comparator;

public class EvenComporator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		
		return o1%2==0 ? (o2%2==0 ? o1-o2 : -1) : (o2%2!=0 ? o2-o1 :1);
	}

}
