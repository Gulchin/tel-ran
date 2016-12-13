package oop.helloworld;

import tel_ran.employees.entities.Company;
import tel_ran.employees.entities.Employee;

public class Manager extends Employee {
	protected double degreeBonus;

	public Manager(int id, String name, int sallary, Company company, double degreeBonus) {
		super(id, name, sallary, company);
		this.degreeBonus = degreeBonus;
	}

	@Override
	public int getSalary() {
		return (int)Math.round(super.getSalary()*degreeBonus);
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" Has manager degree bonus %s", degreeBonus);
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj))
			return false;
		Manager manager=(Manager) obj;
		return this.degreeBonus==manager.degreeBonus;
	}
	
	

}
