package ch08;

public class B extends A {
	double dnum;
	
	public B() {
		super(); // 상위클래스의 기본생성자 호출; 항상 부보클래스가 먼저 생성;
		System.out.println("B의 B()");
	}

	public B(int a, double b) {
		super(a);
		dnum = b;
		System.out.println("B의 B(int, double)");
	}
	
	
}
