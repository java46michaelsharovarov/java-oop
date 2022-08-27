package telran.people.tests;

import java.util.function.Predicate;

import telran.people.Employee;

public class SalaryRangePredicate1 implements Predicate<Employee> {
	private int minSalary;
	private int maxSalary;
		public SalaryRangePredicate1(int minSalary, int maxSalary) {
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}
		@Override
		public boolean test(Employee t) {
			int salary = t.computeSalary();
			return salary >= minSalary && salary <= maxSalary;
		}

}
