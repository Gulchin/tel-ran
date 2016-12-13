package tel_ran.employees.dao;

import java.util.Iterator;

import tel_ran.employees.entities.Employee;
//Дз написать класс limitedWueue, который умеет итерировать, добавлять чилос в конец и брать из начала.
// methods add() offer() fields: int size - реальный размер; int [] elements . ограничение очереди maxsize передается
// через конструктор. Если в очереди ничего нет, возвращаем -1
// Если ничего не удается положить в очередь возвращаем false
//
public class EmployeeIterator implements Iterator<Employee> {
	
	private EmployeesRepository employees;
	private int index=0;
	
	

	public EmployeeIterator(EmployeesRepository employees) {
		super();
		this.employees = employees;
	}

	@Override
	public boolean hasNext() {
		return index<employees.getSize();
	}

	@Override
	public Employee next() {
		return employees.getByIndex(index++);
	}

}
