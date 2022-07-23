package telran.text.comparators;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.Integer.*;

public class DatesComparator implements Comparator<String> {

	@Override
	public int compare(String str1, String str2) {		
		String[] valuesStr1 = str1.split("/");
		String[] valuesStr2 = str2.split("/");		
		int res = 0;
		for (int i = 2; i >= 0; i--) {
			res = Integer.compare(valueOf(valuesStr1[i]), valueOf(valuesStr2[i]));
			if (res != 0) {
				return res;
			} 
		}
		
		
//		Pattern patternDates = Pattern.compile("([1-9]|[12][\\d]|3[01])/([1-9]|1[0-2])/([\\d]{4})"); 
//		Matcher matcherDate1 = patternDates.matcher(str1);
//		Matcher matcherDate2 = patternDates.matcher(str2);
//		int res = 0;
//		if (matcherDate1.matches() && matcherDate2.matches()) {  
//			for (int i = 3; i > 0; i--) {
//				res = Integer.compare(valueOf(matcherDate1.group(i)), valueOf(matcherDate2.group(i)));
//				if (res != 0) {
//					return res;
//				} 
//			}
//		}
		return res;
	}

}
