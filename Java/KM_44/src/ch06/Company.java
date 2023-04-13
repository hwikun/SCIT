package ch06;

// Singleton pattern이 적용된 클래스
public class Company {
	private static Company company = new Company(); // 2.자기 자신의 객체를 멤버로 static하게 생성
	private int total;
	
	private Company() {
		System.out.println("Company 객체 생성");
	} // 1.외부에서 객체 생성 제한 위해 private 생성자 선언
	
	public void addTotal(int total) {
		this.total += total;
	}
	
	// 3. 외부에서 해당 클래스의 객체를 가져다 쓸 수 있는 getter 생성
	public static Company getCompany() {
		return company;
	}
	public int getTotal() {
		return total;
	}
}
