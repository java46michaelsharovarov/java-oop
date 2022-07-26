package telran.people.tests;

import java.util.function.Predicate;

import telran.people.*;

public class SalesEmployeePredicate implements Predicate<Employee> {

	@Override
	public boolean test(Employee t) {
		return t instanceof SalesEmployee;
	}

}
