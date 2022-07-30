package telran.numbers;

import java.util.function.Predicate;

public class MultiplicityOfThreePredicate implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {		
		return t % 3 == 0;
	}

}