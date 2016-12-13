package tel_ran.employees.entities;

//import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
	private int id;
	private String name;
	private int sallary;
	private Company company;
	public Employee(int id, String name, int sallary, Company company) {
		this.id=id;
		this.name = name;
		this.sallary = sallary;
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public int getSalary() {
		return sallary;
	}
	public void setSalary(int salary) {
		this.sallary = salary;
	}
	public Company getComapny() {
		return company;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return String.format("Employe-%s name: %s, has sallary %s, works in the %s.", id,name,sallary,company);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
	Employee employe=(Employee) obj;
		return this.id==employe.id&& this.name.equals(employe.name)&&this.sallary==employe.sallary
				&&this.company.equals(employe.company);
	}
	
	
	
	
}
