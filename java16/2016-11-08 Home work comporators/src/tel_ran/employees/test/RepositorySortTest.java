package tel_ran.employees.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tel_ran.employees.dao.EmployeesRepository;
import tel_ran.employees.entities.Company;
import tel_ran.employees.entities.Employee;
import tel_ran.employees.utils.EmployeeComporators;

public class RepositorySortTest {
	private static final String COMPANY_NAME1 = "Zzz";
	private static final String COUNTRY1 = "Russia";
	private static final String COMPANY_NAME2 = "Microsoft";
	private static final String COUNTRY2 = "Israel";
	private static final String NAME1 = "Ivan Ivanov";
	private static final int SALLARY1 = 30000;
	private static final String NAME2 = "Abram Kats";
	private static final int SALLARY2 = 40000;
	private static final int ID1 = 1;
	private static final int ID2 = 2;
	private static final int ID3 = 3;
	private static final String NAME3 = "Adam Adminov";
	private static final int SALLARY3  = 20000;
	private static final Company COMPANY1=new Company(COMPANY_NAME1,COUNTRY1);
	private static final Company COMPANY2=new Company(COMPANY_NAME2,COUNTRY2);
	private static final Employee IVANOV=new Employee(ID1,NAME1,SALLARY1, COMPANY1);
	private static final Employee KATS=new Employee(ID2, NAME2, SALLARY2, COMPANY2);
	private static final Employee ADMINOV=new Employee(ID3, NAME3, SALLARY3, COMPANY2);
	private static final Employee[] allEmployes={IVANOV,KATS,ADMINOV};
	private static final Employee[] employeesOrderByName={KATS,ADMINOV,IVANOV};
	private static final Employee[] employeesOrderBySalary={ADMINOV,IVANOV,KATS};
	private static final Employee[] employeesOrderByCompany={KATS,ADMINOV,IVANOV};
	EmployeesRepository repository=new EmployeesRepository();
	
	@Before
	public void reset(){
		repository=new EmployeesRepository();
		for(Employee employee: allEmployes){
			repository.addEmployee(employee);
		}
	}

	@Test
	public void testSort() {
		assertArrayEquals(allEmployes, repository.sorted(EmployeeComporators.getComporator(EmployeeComporators.ID)).getAll());
		assertArrayEquals(employeesOrderByName, repository.sorted(EmployeeComporators.getComporator(EmployeeComporators.NAME)).getAll());
		assertArrayEquals(employeesOrderBySalary, repository.sorted(EmployeeComporators.getComporator(EmployeeComporators.SALARY)).getAll());
		assertArrayEquals(employeesOrderByCompany, repository.sorted(EmployeeComporators.getComporator(EmployeeComporators.COMPANY)).getAll());
	}
	
	@Test
	public void testSortByString() {
		assertArrayEquals(allEmployes, repository.sorted(EmployeeComporators.getComporator("Id")).getAll());
		assertArrayEquals(employeesOrderByName, repository.sorted(EmployeeComporators.getComporator("name")).getAll());
		assertArrayEquals(employeesOrderBySalary, repository.sorted(EmployeeComporators.getComporator("sALAry")).getAll());
		assertArrayEquals(employeesOrderByCompany, repository.sorted(EmployeeComporators.getComporator("COMPANY")).getAll());
	}
	
	@Test
	public void testFilterAndSort() {
		assertArrayEquals(new Employee[]{KATS,ADMINOV},
				repository.filteredByCompany(COMPANY2).sorted(EmployeeComporators.getComporator("Id")).getAll());
		assertArrayEquals(new Employee[]{ADMINOV,KATS},
				repository.filteredByCompany(COMPANY2).sorted(EmployeeComporators.getComporator("Salary")).getAll());
		assertArrayEquals(new Employee[]{KATS,IVANOV},
				repository.filteredBySalary(25000, 42000).sorted(EmployeeComporators.getComporator("Company")).getAll());

	}
	
	@Test
	public void tesIteration(){
		Employee[] actual=new Employee[allEmployes.length];
		int i=0;
		for (Employee employee:repository){
			actual[i++]=employee;
		}
		assertArrayEquals(allEmployes,actual);
		
	}

}
