package ch09;

public class MathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = Math.abs(-3);
		System.out.println(num);
		
		System.out.println(Math.round(1.7)); // 반올림
		System.out.println(Math.ceil(-1.7)); // 올림
		System.out.println(Math.floor(1.7)); // 내림
		
		System.out.println(Math.pow(2, 10)); // 2의 10승
		System.out.println(Math.sqrt(2)); // 루트
		
		// System.out.println(Math.random()); // double 값의 0 <= random < 1의 임의의 수
		for(int i=0; i<10; i++) {
			System.out.print((int)(Math.random() * 6)+1);
			if(i != 9) System.out.print(", ");
		}
		System.out.println();
	}

}
