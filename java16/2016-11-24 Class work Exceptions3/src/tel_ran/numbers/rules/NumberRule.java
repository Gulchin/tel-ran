package tel_ran.numbers.rules;

import tel_ran.numbers.exceptions.WrongNumberException;

public interface NumberRule {
	void matches(int number) throws WrongNumberException;
}
