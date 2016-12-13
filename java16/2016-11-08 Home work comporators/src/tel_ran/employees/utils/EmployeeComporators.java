package tel_ran.employees.utils;

import java.util.Comparator;

import tel_ran.employees.entities.Employee;

public enum EmployeeComporators {
	ID,
	NAME,
	SALARY,
	COMPANY;
	
	public static Comparator<Employee> getComporator(EmployeeComporators e){
		switch(e){
		case ID : return new ComparatorId();
		case NAME : return new ComparatorName();
		case SALARY : return new ComporatorSalary();
		case COMPANY : return new ComparatorCompany();
		default: return null;
		}
	}
	
	public static Comparator<Employee> getComporator(String s){
		return getComporator(EmployeeComporators.valueOf(s.toUpperCase()));
	}

}
