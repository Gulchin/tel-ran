package tel_ran.employees.utils;

import tel_ran.employees.entities.Employee;
import tel_ran.employees.entities.Company;
import tel_ran.employees.interfaces.PredicateEmployee;

public class PredicateCompany implements PredicateEmployee {
	private Company company;
	
	
	public PredicateCompany(Company company) {
		super();
		this.company = company;
	}


	@Override
	public boolean test(Employee employee) {
		if (employee==null) return false;
		return company.equals(employee.getComapny());
	}

}
