package tel_ran.employees.dao;

import java.util.Arrays;

import tel_ran.employees.entities.Company;
import tel_ran.employees.entities.Employee;
import tel_ran.employees.interfaces.PredicateEmployee;
import tel_ran.employees.utils.PredicateCompany;
import tel_ran.employees.utils.PredicateName;
import tel_ran.employees.utils.PredicateSalary;

public class EmployeesRepository {
	private Employee [] employees=new Employee[0];
	
	public Employee getEmployee(int id){
		for (Employee employee: employees){
			if(employee.getId()==id) return employee;
		}
		return null;
	}
	
	public boolean addEmployee(Employee employee){
		if(getEmployee(employee.getId())!=null) return false;
		employees=Arrays.copyOf(employees, employees.length+1);
		employees[employees.length-1]=employee;
		return true;
	}
	
	public boolean removeEmployee(int id){
		Employee[] result=new Employee[employees.length-1];

		int count=0;
		for (int i=0;i<employees.length;i++){
			if (employees[i].getId()!=id)
			{
				if(count==employees.length-1) 
					return false;
				result[count++]=employees[i];
			}
		}
		employees=result;
		return true;	
	}
	
	public Employee[] getEmployeeByCompany(Company company){
		return getEmployeeByPredicate(new PredicateCompany(company));
	}
	
	public Employee[] getEmployeeByName(String name){
		return getEmployeeByPredicate(new PredicateName(name));
	}
	
	public Employee[] getEmployeeBySalary(int salaryFrom, int salaryTo){
		return getEmployeeByPredicate(new PredicateSalary(salaryFrom,salaryTo));
	}
	
	public Employee [] getAll(){
		return Arrays.copyOf(employees,employees.length);
	}
	
	private Employee[] getEmployeeByPredicate(PredicateEmployee predicate){
		Employee[] result=new Employee[employees.length];
		int count=0;
		for (int i=0;i<employees.length;i++){
			if (predicate.test(employees[i])){
				result[count++]=employees[i];
			}
		}
		return Arrays.copyOf(result, count);
	}
}
