package ch08;

public class A extends Object{
	// 멤버변수
	int num;
	
	public A() {
		System.out.println("A의 A()");
	}
	
	public A(int n) {
		num = n;
		System.out.println("A의 A(int)");
	}
	
	// 메소드;
	public void test() {
		System.out.println("A클래스의 test()");
	}
}
