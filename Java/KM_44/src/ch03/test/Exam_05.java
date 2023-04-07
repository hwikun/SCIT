package ch03.test;

public class Exam_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp, a = 10, b = 20;
		System.out.printf("교환 전: a = %d, b = %d\n", a, b);
		temp = a; a = b; b = temp; // a, b 상호교환
		System.out.printf("교환 후: a = %d, b = %d", a, b);
	}

}
