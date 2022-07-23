package telran.text;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import telran.text.comparators.DatesComparator;

public class Strings {
	
	public static String[] sortStringsAsDates(String [] dates) {
		Pattern patternDates = Pattern.compile("([1-9]|[12][\\d]|3[01])/([1-9]|1[0-2])/[\\d]{4}");
		for (String date: dates) {
			Matcher matcherDate = patternDates.matcher(date);
			if (!matcherDate.matches()) {
				return dates;
			} 
		}
		String[] res = Arrays.copyOf(dates, dates.length);
		Arrays.sort(res, new DatesComparator());
		return res;
	}
	
}