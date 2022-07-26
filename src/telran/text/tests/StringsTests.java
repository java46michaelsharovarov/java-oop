package telran.text.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.people.Employee;
import telran.people.SalesEmployee;
import telran.text.Strings;

class StringsTests {
	private static final String DATE_1 = "1/1/1990";
	private static final String DATE_2 = "2/1/1990";
	private static final String DATE_3 = "10/9/2000";
	private static final String DATE_4 = "15/11/2002";
	private static final String DATE_5 = "31/12/2005";
	private static final String DATE_6 = "30/8/2020";
	private static final String DATE_7 = "31/8/2020";
	private static final String WRONG_DATE = "32/8/2020";
	
	@Test
	void sortStringsAsDates() {
		String[] ar = {DATE_4, DATE_1, DATE_6, DATE_2, DATE_7, DATE_3, DATE_5};
		String[] expected = {DATE_1, DATE_2, DATE_3, DATE_4, DATE_5, DATE_6, DATE_7};
		assertArrayEquals(expected, Strings.sortStringsAsDates(ar));
	}
	
	@Test
	void wrongDate() {
		String[] ar = {DATE_4, DATE_1, DATE_6, DATE_2, WRONG_DATE, DATE_3, DATE_5};
		try {
			Strings.sortStringsAsDates(ar);
			fail("Exeption was not thrown");
			
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
