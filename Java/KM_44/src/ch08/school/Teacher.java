package ch08.school;

public class Teacher extends Person{
	private int salary;
	
	public Teacher() {
		super();
	}

	public Teacher(String name, String id, String phone, int salaly) {
		super(name, id, phone);
		this.salary = salaly;
	}

	public int getSalaly() {
		return salary;
	}

	public void setSalaly(int salaly) {
		this.salary = salaly;
	}

	
	public String toString(int a) {
		// TODO Auto-generated method stub
		return super.toString() + "급여: " + salary + a;
		
	}
	
	
	
}
