package telran.people.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.people.Employee;
import telran.people.WageEmployee;
import telran.people.SalesEmployee;

class EmployeesTests {

	@Test
	void Employee() {
		Employee employee = new Employee(45679123, 2000, "email@email.com", 15000);
		assertEquals(45679123, employee.getId());
		assertEquals(2000, employee.getBirthYear());
		assertEquals("email@email.com", employee.getEmail());
		assertEquals(15000, employee.computeSalary());
		employee.setBasicSalary(10000);
		assertEquals(10000, employee.computeSalary());
	}
	@Test
	void WageEmployee() {		
		WageEmployee wageEmployee = 
				new WageEmployee(45679123, 2000, "email@email.com", 15000, 50, 20);
		assertEquals(16000, wageEmployee.computeSalary());
		wageEmployee.setWage(30);
		wageEmployee.setHours(10);
		assertEquals(15300, wageEmployee.computeSalary());
	}
	@Test
	void SalesEmployee() {		
		SalesEmployee salesEmployee = 
				new SalesEmployee(45679123, 2000, "email@email.com", 15000, 10000, 5);
		assertEquals(15500, salesEmployee.computeSalary());
		salesEmployee.setSales(20000);
		salesEmployee.setPercentPay(10);
		assertEquals(17000, salesEmployee.computeSalary());
	}
}
