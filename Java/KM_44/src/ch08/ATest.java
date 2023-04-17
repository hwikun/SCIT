package ch08;

public class ATest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a1 = new A();
		A a2 = new A(100);
		
		a1.num = 1;
		a1.test();
		
		B b1 = new B();
		B b2 = new B(10, 2.3);
		
		b2.test();
		System.out.println(b2.toString());
		
		C c = new C();
		c.setBounds(100, 100, 300, 300);
		c.setTitle("내가만든창");
		c.setVisible(true);
	}

}
