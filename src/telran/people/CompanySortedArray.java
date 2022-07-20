package telran.people;

import java.util.Arrays;
import java.lang.System;

public class CompanySortedArray extends CompanyArray {
	@Override
	public boolean addEmployee(Employee empl) {		
		int index = getEmployeeIndex(empl.getId());
		if(index > 0) {
			return false;
		}
		index = -(index + 1); 
		Employee[] tmp = new Employee[employees.length + 1];
		System.arraycopy(employees, 0, tmp, 0, index);
		tmp[index] = empl;
		System.arraycopy(employees, index, tmp, index  + 1, employees.length - index);
		employees = tmp;
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