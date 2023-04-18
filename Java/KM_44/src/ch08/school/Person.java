package ch08.school;

public abstract class Person { // 추상클래스
	private String name, id, phone;
	
	public Person() {
		super();
	}
	
	public Person(String name, String id, String phone) {
		super();
		this.name = name;
		this.id = id;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	// Overriding = 상속받은 메소드를 재정의;
	// 리턴타입 같고 접근지정자는 같거나 더 개방적, 이름은 같고, 예외는 같거나 더 하위타입으로;
	public String toString() {
		return "이름: " + name + "\n주민등록번호: " + id + "\n전화번호: " + phone;
	}
}
