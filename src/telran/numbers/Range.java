package telran.numbers;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Range implements Iterable<Integer> {	
	//closed range
	private int min; //inclusive
	private int max; //inclusive 
	private Predicate<Integer> predicate;
	
	public Range(int min, int max) {	
		this.min = min;
		this.max = max;
	}
	
	public Predicate<Integer> getPredicate() {
		return predicate;
	}
	
	public void setPredicate(Predicate<Integer> predicate) {
		this.predicate = predicate;
	}
	
	@Override
	public Iterator<Integer> iterator() {		
		return new RangeIterator();
	}
	
	public int length () {
		return max - min + 1;
	}
	
	private class RangeIterator implements Iterator<Integer> {
		boolean predicateIsNull = predicate == null;
		int current = predicateIsNull ? min : predicate.test(min) ? min : min + 1;
		int prevCurrent;
		
        @Override
		public boolean hasNext() {
			return current <= max;
		}

		@Override
		public Integer next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			prevCurrent = current;
			current = predicateIsNull ? current + 1 : current + 2;
			return prevCurrent;
		}		
	}
}