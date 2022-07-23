package telran.people;

import java.util.Arrays;
import java.lang.System;

public class CompanySortedArray extends CompanyArray {
	@Override
	public boolean addEmployee(Employee empl) {		
		int index = getEmployeeIndex(empl.getId());
		if(index >= 0) {
			return false;
		}
		index = -(index + 1);
		employees = Arrays.copyOf(employees, employees.length + 1);
		System.arraycopy(employees, index, employees, index + 1, employees.length - 1 - index);
		employees[index] = empl;
		return true;
	}	
	@Override 
	protected int getEmployeeIndex(long id) {
		Person per = new Person(id, 0, null);
		return Arrays.binarySearch(employees, per);
	}
	@Override
	public Employee[] getAllEmployees() {
		return Arrays.copyOf(employees, employees.length);
	}
}