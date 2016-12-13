package tel_ran.numbers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import tel_ran.numbers.interfaces.INumberBox;
import tel_ran.numbers.util.EvenPredicate;
import tel_ran.numbers.util.RangePredicate;

public abstract class AbstractNumbersBox implements INumberBox {
	protected Collection<Integer> numbers;
	@Override
	public Iterator<Integer> iterator() {
		return numbers.iterator();
	}

	@Override
	public int size() {
		return numbers.size();
	}

	@Override
	public boolean contains(int number) {
		return numbers.contains(number);
	}

	@Override
	public void removeEvenNumbers() {
		removeByPredicate(new EvenPredicate());

	}

	@Override
	public void removeOddNumbers() {
		removeByPredicate(new EvenPredicate().negate());

	}

	@Override
	public void removeNumbersInRange(int min, int max) {
		removeByPredicate(new RangePredicate(min, max));

	}

	protected void removeByPredicate(Predicate<Integer> predicate){
		Iterator<Integer> it=iterator();
		while(it.hasNext()){
			int num=it.next();
			if(predicate.test(num)) it.remove();;
		}
	}
	@Override
	public void removeNumber(int number) {
		numbers.remove(number);

	}

	@Override
	public void removeRepeted() {
		Iterator<Integer> it=iterator();
		HashSet<Integer> tempList=new HashSet<>();
		while(it.hasNext()){
			int num=it.next();
			if(tempList.contains(num)) 
					it.remove();
			else tempList.add(num);
		}
	}

	@Override
	public void add(int number) {
		numbers.add(number);

	}

	@Override
	public void clear() {
		numbers.clear();
		
	}
	
	

}
