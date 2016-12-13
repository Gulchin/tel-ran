package oop.helloworld;

import tel_ran.employees.entities.Company;

public class SalesPerson extends WageEmploye {
	protected int interest;
	protected int sales;
	public SalesPerson(int id, String name, int sallary, Company company, int wage, int workingHours, int interest,
			int sales) {
		super(id, name, sallary, company, wage, workingHours);
		this.interest = interest;
		this.sales = sales;
	}
	@Override
	public int getSalary() {
		return super.getSalary() +interest*sales/100;
	}
	@Override
	public String toString() {
		return super.toString() +String.format(" Total sales in this month %s. Interest %s persent", sales,interest);
	}
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) 
			return false;
		SalesPerson sales=(SalesPerson)obj;
		return this.interest==sales.interest&&this.sales==sales.sales;
	}
	public int getInterest() {
		return interest;
	}
	public void setInterest(int interest) {
		this.interest = interest;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	
	

}
