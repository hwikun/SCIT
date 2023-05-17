package school.vo;

import java.io.Serializable;

public abstract class Person implements Serializable { // 추상클래스
	private static final long serialVersionUID = 7633183897933606138L;
	private String name, id, phone;
	
	public Person() {
		super();
	}
	
	public Person(String id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
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
		return "\n학번: " + id + "이름: " + name + "\n전화번호: " + phone;
	}
}
