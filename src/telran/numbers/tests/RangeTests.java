package telran.numbers.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.numbers.Range;

class RangeTests {
	Range range;
	Predicate<Integer> AllFalsePredicate = e -> false;
	Predicate<Integer> EvenPredicate = e -> e % 2 == 0;
	Predicate<Integer> MultiplicityOfThreePredicate = e -> e % 3 == 0;
	Predicate<Integer> OddPredicate = e -> e % 2 != 0;
	
	@BeforeEach
	void setUp() throws Exception {
		range = new Range(1, 9);
	}
	
	@Test
	void lengthTest() {
		assertEquals(9, range.length());
	}
	
	@Test
	void iterableNoPredicateTest() {
		int expected[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int actual[] = getActualArray(9);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void iterableEvenNumbersPredicateTest() {
		int expected[] = {2, 4, 6, 8};
		range.setPredicate(EvenPredicate);
		int actual[] = getActualArray(4);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void iterableOddNumbersPredicateTest() {
		int expected[] = {1, 3, 5, 7, 9};
		range.setPredicate(OddPredicate);
		int actual[] = getActualArray(5);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void iterableMultiplicityOfThreePredicateTest() {
		int expected[] = {3, 6, 9};
		range.setPredicate(MultiplicityOfThreePredicate);
		int actual[] = getActualArray(3);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void iterableTrueNumbersPredicateTest() {
		int expected[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		range.setPredicate(AllFalsePredicate.negate());
		int actual[] = getActualArray(9);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void iterableFalseNumbersPredicateTest() {
		int expected[] = {};
		range.setPredicate(AllFalsePredicate);
		int actual[] = getActualArray(0);
		assertArrayEquals(expected, actual);
	}

	private int[] getActualArray(int size) {
		int [] res = new int[size];
		int ind = 0;
		for(int num: range) {
			res[ind++] = num;
		}
		return res;
	}

}