package ch09.method;

public class MethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data d1 = new Data();
		Data d2 = new Data(10, 20);
		System.out.println(d1);
		System.out.println(d2);
		
		d1.print();
		System.out.println(d2.sum()); // 30;
		System.out.println(d1.sum());
		System.out.println(Data.sum(10, 50));
		System.out.println(Data.sum(1, 10, 2)); // 1에서 10까지 2씩증가하면서 합계;
		
		// 임시마다 데이터를 받아서계산하는 static method;
		System.out.println(Data.power(2, 3)); // 2의3승;
	}

}
