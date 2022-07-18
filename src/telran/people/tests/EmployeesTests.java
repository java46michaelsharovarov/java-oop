package telran.people.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.people.Employee;
import telran.people.WageEmployee;
import telran.people.SalesEmployee;

class EmployeesTests {
	private static final int ID = 45679123;
	private static final int BIRTH_YEAR = 2000;
	private static final int BASIC_SALARY = 15000;
	private static final int WAGE = 50;
	private static final int ANOTHER_WAGE = 30;
	private static final int HOYRS = 20;
	private static final int ANOTHER_HOYRS = 10;
	private static final int SALES = 10;
	private static final int PERCENT_PAY = 2;
	private static final int ANOTHER_PERCENT_PAY = 10;
	@Test
	void Employee() {
		Employee employee = new Employee(ID, BIRTH_YEAR, "email@email.com", BASIC_SALARY);
		assertEquals(ID, employee.getId());
		assertEquals(BIRTH_YEAR, employee.getBirthYear());
		assertEquals("email@email.com", employee.getEmail());
		assertEquals(BASIC_SALARY, employee.computeSalary());
		employee.setBasicSalary(10000);
		assertEquals(10000, employee.computeSalary());
	}
	@Test
	void WageEmployee() {		
		WageEmployee wageEmployee = 
				new WageEmployee(ID, BIRTH_YEAR, "email@email.com", BASIC_SALARY, WAGE, HOYRS);
		assertEquals(16000, wageEmployee.computeSalary());
		wageEmployee.setWage(ANOTHER_WAGE);
		wageEmployee.setHours(ANOTHER_HOYRS);
		assertEquals(15300, wageEmployee.computeSalary());
	}
	@Test
	void SalesEmployee() {		
		SalesEmployee salesEmployee = 
				new SalesEmployee(ID, BIRTH_YEAR, "email@email.com", BASIC_SALARY, SALES, PERCENT_PAY);
		assertEquals(15000,2 , salesEmployee.computeSalary());
		salesEmployee.setSales(20000);
		salesEmployee.setPercentPay(ANOTHER_PERCENT_PAY);
		assertEquals(17000, salesEmployee.computeSalary());
	}
}
