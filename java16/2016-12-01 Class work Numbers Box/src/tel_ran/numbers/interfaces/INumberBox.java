package tel_ran.numbers.interfaces;

public interface INumberBox extends Iterable<Integer> {
	int size();//return amount of the numbers in the box
	/**
	 * returns true if a given number exists in the box
	 * @param number
	 * @return
	 */
	boolean contains(int number);
	void removeEvenNumbers();
	void removeOddNumbers();
	/**
	 * removes all numbers of the range [min,max]
	 * @param min
	 * @param max
	 */
	void removeNumbersInRange(int min,int max);
	/**
	 * removes specified number, all od them 
	 * @param number
	 */
	void removeNumber(int number);
	/**
	 * removes all repetitions remainig just one;
	 */
	void removeRepeted();
	/**
	 * adds new number to the box
	 * @param number
	 */
	void add(int number);
	
	void clear();
}
