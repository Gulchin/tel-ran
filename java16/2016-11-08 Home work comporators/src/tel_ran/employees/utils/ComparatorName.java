package tel_ran.employees.utils;

import java.util.Comparator;

import tel_ran.employees.entities.Employee;

public class ComparatorName implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

}
