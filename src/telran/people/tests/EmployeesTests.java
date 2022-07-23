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
	private static final String EMAIL = "email@email.com";
	
	@Test
	void Employee() {
		Employee employee = new Employee(ID, BIRTH_YEAR, EMAIL, BASIC_SALARY);
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
				new WageEmployee(ID, BIRTH_YEAR, EMAIL, BASIC_SALARY, WAGE, HOYRS);
		assertEquals(16000, wageEmployee.computeSalary());
		wageEmployee.setWage(ANOTHER_WAGE);
		wageEmployee.setHours(ANOTHER_HOYRS);
		assertEquals(15300, wageEmployee.computeSalary());
	}
	
	@Test
	void SalesEmployee() {		
		SalesEmployee salesEmployee = 
				new SalesEmployee(ID, BIRTH_YEAR, EMAIL, BASIC_SALARY, SALES, PERCENT_PAY);
		assertEquals(15000,2 , salesEmployee.computeSalary());
		salesEmployee.setSales(20000);
		salesEmployee.setPercentPay(ANOTHER_PERCENT_PAY);
		assertEquals(17000, salesEmployee.computeSalary());
	}

	@Test
	void wrongBirthYear() {
		boolean hasException = false;
		try {
			new SalesEmployee(ID, 2018, EMAIL, BASIC_SALARY, SALES, PERCENT_PAY);
			
		} catch (IllegalArgumentException e) {
			hasException = true;
			System.out.println(e.getMessage());
		}
		assertTrue(hasException);
		hasException = false;
		try {
			new Employee(ID, 1913, EMAIL, BASIC_SALARY);
		} catch (IllegalArgumentException e) {
			hasException = true;
			System.out.println(e.getMessage());
		}
		assertTrue(hasException);
	}
	
	@Test
	void wrongEmail() {
		boolean hasException = false;
		try {
			new SalesEmployee(ID, BIRTH_YEAR, "vasya@tel-ran.com", BASIC_SALARY, SALES, PERCENT_PAY);
			
		} catch (IllegalArgumentException e) {
			hasException = true;
			System.out.println(e.getMessage());
		}
		assertTrue(hasException);	
		hasException = false;
		try {
			new SalesEmployee(ID, BIRTH_YEAR, null, BASIC_SALARY, SALES, PERCENT_PAY);
			
		} catch (IllegalArgumentException e) {
			hasException = true;
			System.out.println(e.getMessage());
		}
		assertFalse(hasException);	
	}
	
	@Test
	void wrongBasicSalary() {
		boolean hasException = false;
		try {
			new SalesEmployee(ID, BIRTH_YEAR, EMAIL, 99, SALES, PERCENT_PAY);
			
		} catch (IllegalArgumentException e) {
			hasException = true;
			System.out.println(e.getMessage());
		}
		assertTrue(hasException);		
	}
	
	@Test
	void wrongPercentPay() {
		boolean hasException = false;
		try {
			new SalesEmployee(ID, BIRTH_YEAR, EMAIL, BASIC_SALARY, SALES, -1);
			
		} catch (IllegalArgumentException e) {
			hasException = true;
			System.out.println(e.getMessage());
		}
		assertTrue(hasException);	
		hasException = false;
		try {
			new SalesEmployee(ID, BIRTH_YEAR, EMAIL, BASIC_SALARY, SALES, 101);
			
		} catch (IllegalArgumentException e) {
			hasException = true;
			System.out.println(e.getMessage());
		}
		assertTrue(hasException);
	}
}
