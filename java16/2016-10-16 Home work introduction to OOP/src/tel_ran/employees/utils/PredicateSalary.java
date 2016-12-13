package tel_ran.employees.utils;

import tel_ran.employees.entities.Employee;
import tel_ran.employees.interfaces.PredicateEmployee;

public class PredicateSalary implements PredicateEmployee {
	
	private int from,to;
	

	public PredicateSalary(int from, int to) {
		super();
		this.from = from;
		this.to = to;
	}


	@Override
	public boolean test(Employee employee) {
		int salary=employee.getSalary();
		return salary>=from && salary<=to;
	}

}
