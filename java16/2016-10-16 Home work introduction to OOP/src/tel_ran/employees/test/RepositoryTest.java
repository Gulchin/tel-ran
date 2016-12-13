package tel_ran.employees.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tel_ran.employees.dao.EmployeesRepository;
import tel_ran.employees.entities.Company;
import tel_ran.employees.entities.Employee;

public class RepositoryTest {
	private static final String COMPANY_NAME1 = "1C";
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
	private static final String NAME4 = "Sema Rabinovich";
	private static final Company COMPANY1=new Company(COMPANY_NAME1,COUNTRY1);
	private static final Company COMPANY2=new Company(COMPANY_NAME2,COUNTRY2);
	private static final Employee IVANOV=new Employee(ID1,NAME1,SALLARY1, COMPANY1);
	private static final Employee KATS=new Employee(ID2, NAME2, SALLARY2, COMPANY2);
	private static final Employee ADMINOV=new Employee(ID3, NAME3, SALLARY3, COMPANY2);
	EmployeesRepository repository=new EmployeesRepository();
	
	@Before
	public void reset(){
		repository=new EmployeesRepository();
	}
	
	
	@Test
	public void testGet() {
		repository.addEmployee(IVANOV);
		repository.addEmployee(KATS);
		assertEquals(IVANOV, repository.getEmployee(ID1));
		assertEquals(null, repository.getEmployee(ID3));
	}
	
	@Test
	public void testAdd() {
		repository.addEmployee(IVANOV);
		assertArrayEquals(new Employee[]{IVANOV}, repository.getAll());
		assertEquals(true,repository.addEmployee(KATS));
		assertEquals(false,repository.addEmployee(KATS));
		assertArrayEquals(new Employee[]{IVANOV,KATS}, repository.getAll());
	}
	
	@Test
	public void testRemove() {
		repository.addEmployee(IVANOV);
		repository.addEmployee(KATS);
		repository.addEmployee(ADMINOV);
		assertEquals(true,repository.removeEmployee(ID1));
		assertEquals(false,repository.removeEmployee(ID1));
		assertArrayEquals(new Employee[]{KATS,ADMINOV}, repository.getAll());
		repository.removeEmployee(ID2);
		assertArrayEquals(new Employee[]{ADMINOV}, repository.getAll());
	}
	
	@Test
	public void testGetByCompany(){
		repository.addEmployee(IVANOV);
		repository.addEmployee(KATS);
		repository.addEmployee(ADMINOV);
		assertArrayEquals(new Employee[]{KATS,ADMINOV}, repository.getEmployeeByCompany(COMPANY2));
		assertArrayEquals(new Employee[]{IVANOV}, repository.getEmployeeByCompany(COMPANY1));
		repository.removeEmployee(ID1);
		assertArrayEquals(new Employee[]{}, repository.getEmployeeByCompany(COMPANY1));
	}
	
	@Test
	public void testGetByName(){
		repository.addEmployee(IVANOV);
		repository.addEmployee(KATS);
		repository.addEmployee(ADMINOV);
		assertArrayEquals(new Employee[]{KATS}, repository.getEmployeeByName(NAME2));
		assertArrayEquals(new Employee[]{IVANOV}, repository.getEmployeeByName(NAME1));
		assertArrayEquals(new Employee[]{}, repository.getEmployeeByName(NAME4));
	}
	@Test	
	public void testGetBySalary(){
		repository.addEmployee(IVANOV);
		repository.addEmployee(KATS);
		repository.addEmployee(ADMINOV);
		assertArrayEquals(new Employee[]{IVANOV,KATS}, repository.getEmployeeBySalary(29000, 41000));
		assertArrayEquals(new Employee[]{IVANOV}, repository.getEmployeeBySalary(29000, 31000));
		assertArrayEquals(new Employee[]{}, repository.getEmployeeBySalary(100, 10000));
	}
	

}
