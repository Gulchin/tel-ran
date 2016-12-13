package oop.helloworld;

import tel_ran.employees.entities.Company;
import tel_ran.employees.entities.Employee;

public class WageEmploye extends Employee {
	protected int wage;
	protected int workingHours;
	public WageEmploye(int id, String name, int sallary, Company company, int wage, int workingHours) {
		super(id, name, sallary, company);
		this.wage = wage;
		this.workingHours = workingHours;
	}
	@Override
	public int getSalary() {
		return super.getSalary()+wage*workingHours;
	}
	@Override
	public String toString() {
		return super.toString()+String.format(" %s hours worked in this month. Wage rate: %s per hour.", workingHours, wage);
	}
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) 
			return false;
		WageEmploye employe=(WageEmploye) obj;
		return this.wage==employe.wage&&this.workingHours==employe.workingHours;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}
	public int getWage() {
		return wage;
	}
	public int getWorkingHours() {
		return workingHours;
	}
	
	
	

}
