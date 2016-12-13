package tel_ran.exceptionhandling;

import java.util.function.Predicate;

public class MemoryAlocator implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {
		byte [] array;
		try{
			array=new byte[t];
			array=null;
			return true;
		} catch(Throwable e){
			return false;
		}
	}

}
