package telran.people;

public class SalesEmployee extends Employee {
	private int sales;
	private int percentPay;
	public SalesEmployee(long id, int birthYear, String email, int basicSalary, int sales, int percentPay) {
		super(id, birthYear, email, basicSalary);
		setSales(sales);
		setPercentPay(percentPay);
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public void setPercentPay(int percentPay) {
		this.percentPay = percentPay;
	}
	@Override
	public int computeSalary() {
		return super.computeSalary() + (int) Math.round(this.sales / 100.0 * this.percentPay);
	}
}
