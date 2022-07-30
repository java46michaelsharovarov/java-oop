package telran.numbers;

import java.util.function.Predicate;

public class TrueNumbersPredicate implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {		
		return true;
	}

}