package tel_ran.employees.utils;

import tel_ran.employees.entities.Employee;
import tel_ran.employees.interfaces.PredicateEmployee;

public class PredicateName implements PredicateEmployee {
	private String name;
	
	
	
	public PredicateName(String name) {
		super();
		this.name = name;
	}



	@Override
	public boolean test(Employee employee) {
		if (employee==null) return false;
		return name.equals(employee.getName());
	}

}
