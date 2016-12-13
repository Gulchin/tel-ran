package tel_ran.numbers.controller;

import tel_ran.numbers.RangeExceptions;
import tel_ran.numbers.excepsion.GreaterThanMaxException;
import tel_ran.numbers.excepsion.LessThanMinException;
// Дз для класса limitedqueue написать плеер, который случайным образом добавляет или убирает числа из очереди
// посчитать сколько было попыток взять из пустой очереди или положить в уже заполненную
// для управления вероятностью добавить константу ADD_Probability - допустим 30%
// определить вероятность простоя и отказа добавления в очередь.
public class RangeExceptionTestApp {
	static final int MIN_RANGE = 100;
	static final int MAX_RANGE = 500;
	static final int MIN_NUMBER = 100;
	static final int MAX_NUMBER = 501;
	static final int N_NUMBERS = 100000;

	public static void main(String[] args) {

		RangeExceptions range = new RangeExceptions(MIN_RANGE, MAX_RANGE);
		RangeExceptions bigRange = new RangeExceptions(MIN_NUMBER, MAX_NUMBER);
		int less = 0;
		int greater = 0;
		for (int i = 0; i < N_NUMBERS; i++) {
			try {
				range.check(bigRange.getRandom());
			} catch (LessThanMinException e) {
				less++;
			} catch (GreaterThanMaxException e) {
				greater++;
			}
		}
		System.out.println("less: " + less);
		System.out.println("greater: " + greater);
	}

}
