package ch08.school;

public class Teacher extends Person{
	private int salaly;
	
	public Teacher() {
		super();
	}

	public Teacher(String name, String id, String phone, int salaly) {
		super(name, id, phone);
		this.salaly = salaly;
	}

	public int getSalaly() {
		return salaly;
	}

	public void setSalaly(int salaly) {
		this.salaly = salaly;
	}

	
	public String toString(int a) {
		// TODO Auto-generated method stub
		return super.toString() + "급여: " + salaly + a;
		
	}
	
	
	
}
