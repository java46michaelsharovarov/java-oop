package telran.people;

import java.util.regex.Pattern;

public class Person  implements Comparable<Person>{
	protected long id;
	private int birthYear;
	private String email;
	private static Pattern patternEmail = Pattern.compile("[A-Za-z\\d\\.-]+@[A-Za-z\\.]+");
	public Person(long id, int birthYear, String email) {
		this.id = id;
		this.birthYear = birthYear;
		setEmail(email);
	}
	public void setEmail(String email) {
		if (email != null) {
			if (!patternEmail.matcher(email).matches()) {
				throw new IllegalArgumentException(String.format(
						"%s - wrong email, " + "may contain " + "any ASCII letter, any digit, dot (.), dash ()",
						email));
			} 
		}
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public String getEmail() {
		return email;
	}
	@Override
	public int compareTo(Person o) {		
		return Long.compare(this.id, o.id);
	}	
}
