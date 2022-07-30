package telran.numbers;

import java.util.function.Predicate;

public class FalseNumbersPredicate implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {		
		return false;
	}

}