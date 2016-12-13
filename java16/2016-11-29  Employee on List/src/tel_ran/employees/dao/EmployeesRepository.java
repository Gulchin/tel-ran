package tel_ran.employees.dao;

import java.util.*;


import tel_ran.employees.entities.Company;
import tel_ran.employees.entities.Employee;
import tel_ran.employees.interfaces.PredicateEmployee;
import tel_ran.employees.utils.PredicateCompany;
import tel_ran.employees.utils.PredicateName;
import tel_ran.employees.utils.PredicateSalary;

public class EmployeesRepository implements Iterable<Employee>{
	private List<Employee> employees=new ArrayList<>();
	
	public Employee getEmployee(int id){
		for (Employee employee: employees){
			if(employee.getId()==id) return employee;
		}
		return null;
	}
	
	public boolean addEmployee(Employee employee){
		if(getEmployee(employee.getId())!=null) return false;
		employees.add(employee);
		return true;
	}
	
	public boolean removeEmployee(int id){
		Iterator<Employee> it=employees.iterator();
		while(it.hasNext()){
			Employee employee=it.next();
			if(employee.getId()==id){
				employees.remove(employee);
				return true;
			}
		}
		return false;	
	}
	
	public List<Employee> getEmployeeByCompany(Company company){
		return getEmployeeByPredicate(new PredicateCompany(company));
	}
	
	public List<Employee>getEmployeeByName(String name){
		return getEmployeeByPredicate(new PredicateName(name));
	}
	
	public List<Employee> getEmployeeBySalary(int salaryFrom, int salaryTo){
		return getEmployeeByPredicate(new PredicateSalary(salaryFrom,salaryTo));
	}
	
	public EmployeesRepository filteredByCompany(Company company){
		EmployeesRepository result=new EmployeesRepository();
		result.employees=getEmployeeByCompany(company);
		return result;
	}
	
	public EmployeesRepository filteredByName(String name){
		EmployeesRepository result=new EmployeesRepository();
		result.employees=getEmployeeByName(name);
		return result;
	}
	
	public EmployeesRepository filteredBySalary(int salaryFrom, int salaryTo){
		EmployeesRepository result=new EmployeesRepository();
		result.employees=getEmployeeBySalary(salaryFrom,salaryTo);
		return result;
	}
	
	public EmployeesRepository sorted(Comparator<Employee> orderBy){
		EmployeesRepository result=new EmployeesRepository();
		result.employees=getAll();
		Collections.sort(result.employees,orderBy);
		return result;
	}

	public Employee getByIndex(int index){
		return employees.get(index);
	}
	
	public int getSize(){
		return employees.size();
	}
	
	public List<Employee> getAll(){
		return new ArrayList<>(employees);
	}
	
	private List<Employee> getEmployeeByPredicate(PredicateEmployee predicate){
		List<Employee> result=new ArrayList<>();
		for(Employee employee: employees){
			if (predicate.test(employee))
			result.add(employee);
		}
		return result;
	}

	@Override
	public Iterator<Employee> iterator() {
		return new EmployeeIterator(this);
	}
}
