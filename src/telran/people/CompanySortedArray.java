package telran.people;

import java.util.Arrays;
import java.lang.System;

public class CompanySortedArray extends CompanyArray {
	@Override
	public boolean addEmployee(Employee empl) {
		if (getEmployee(empl.getId()) != null) {
			return false;
		}
		int index = getEmployeeIndex(empl.getId());
		index = index < 0 ? -(index + 1) : index; 
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