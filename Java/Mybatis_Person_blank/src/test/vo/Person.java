package test.vo;

/**
 * ���� ������ ������ VO Ŭ����
 */
public class Person {
	private int num;					//�Ϸù�ȣ
	private String name;				//�̸�
	private int age;					//����
	
	public Person() {
	}
	
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Person(int num, String name, int age) {
		this.num = num;
		this.name = name;
		this.age = age;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [num=" + num + ", name=" + name + ", age=" + age + "]";
	}
}
