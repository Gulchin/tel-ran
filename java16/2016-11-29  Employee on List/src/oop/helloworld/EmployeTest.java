package oop.helloworld;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tel_ran.employees.entities.Company;
import tel_ran.employees.entities.Employee;

public class EmployeTest {
	
	private static final String COMPANY_NAME1 = "1C";
	private static final String COUNTRY1 = "Russia";
	private static final String COMPANY_NAME2 = "Microsoft";
	private static final String COUNTRY2 = "Israel";
	private static final String NAME1 = "Ivan Ivanov";
	private static final int SALLARY1 = 30000;
	private static final String NAME2 = "Abram Kats";
	private static final int SALLARY2 = 30000;
	private static final int ID1 = 1;
	private static final int ID2 = 2;
	private static final int ID3 = 3;
	private static final String NAME3 = "Adam Adminov";
	private static final int WAGE2 = 30;
	private static final int WORKING_HOURS1 = 20;
	private static final int INTEREST = 20;
	private static final int SALES = 10000;
	private static final int ID4 = 4;
	private static final String NAME4 = "Sema Rabinovich";
	private static final double DEGREE_BONUS = 1.5;
	Company company1=new Company(COMPANY_NAME1,COUNTRY1);
	Company company2=new Company(COMPANY_NAME2,COUNTRY2);
	Employee employe1=new Employee(ID1,NAME1, SALLARY1, company1);
	Employee employe2=new Employee(ID2,NAME2, SALLARY2, company2);
	WageEmploye admin;
	SalesPerson sales;
	Manager manager;
	Employee [] employes;
	
	@Before
	public void prepare(){
		admin=new WageEmploye(ID3, NAME3, SALLARY1, company2, WAGE2, WORKING_HOURS1);
		sales=new SalesPerson(ID4, NAME4, SALLARY1, company2, WAGE2, WORKING_HOURS1, INTEREST, SALES);
		manager=new Manager(ID4, NAME4, SALLARY1, company2, DEGREE_BONUS);
		employes=new Employee[]{employe2,admin,sales,manager};
	}
	
	@Test	
	public void testToString() {
		System.out.println(employe1);
		System.out.println(employe2);
		System.out.println(admin);
		System.out.println(sales);
		System.out.println(manager);
	}
	
	@Test	
	public void testGetters(){
		assertEquals(NAME1, employe1.getName());
		assertEquals(SALLARY1, employe1.getSalary());
		assertEquals(company1, employe1.getComapny());
		assertEquals(company1.getCountry(), employe1.getComapny().getCountry());
	
	}
	@Test	
	public void testEquals(){
		assertEquals(employe1,new Employee(ID1,NAME1, SALLARY1, company1));
		assertEquals(employe2,new Employee(ID2,NAME2, SALLARY2, company2));
		assertEquals(company1,new Company(COMPANY_NAME1,COUNTRY1));
		assertEquals(admin,new WageEmploye(ID3, NAME3, SALLARY1, company2, WAGE2, WORKING_HOURS1));
		assertEquals(sales,new SalesPerson(ID4, NAME4, SALLARY1, company2, WAGE2, WORKING_HOURS1, INTEREST, SALES));
		assertEquals(manager,new Manager(ID4, NAME4, SALLARY1, company2, DEGREE_BONUS));
	}
	
	@Test
	public void testSallary(){
		int sum=0;
		for(Employee e:employes){
			System.out.println(e.getName() +"'s sallary: "+e.getSalary() );
			sum+=e.getSalary();
		}
		assertEquals(SALLARY2+SALLARY2+WAGE2*WORKING_HOURS1+SALLARY2+WAGE2*WORKING_HOURS1+
				INTEREST*SALES/100+(int)Math.round(SALLARY2*DEGREE_BONUS),sum);
				
	}


}
