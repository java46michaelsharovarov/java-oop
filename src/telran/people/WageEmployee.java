package telran.people;

public class WageEmployee extends Employee {
	private int wage;
	private int hours;
	public WageEmployee(long id, int birthYear, String email, int basicSalary, int wage, int hours) {
		super(id, birthYear, email, basicSalary);
		setWage(wage);
		setHours(hours);
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	@Override
	public int computeSalary() {
		return super.computeSalary() + (this.wage * this.hours);
	}
	
}
