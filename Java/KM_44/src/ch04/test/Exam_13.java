package ch04.test;

public class Exam_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=0;i<10;i++) {
			System.out.printf("%d ", i);
		}
		System.out.println("");
		for(int i=1;i<11;i++) {
			System.out.printf("%d ", i);
		}
		System.out.println("");
		for(int i=0;i<10;i++) {
			if (i % 2 == 1) System.out.printf("%d ", i);
		}
		System.out.println("");
		for(int i=0;i<11;i++) {
			if (i % 2 ==0) System.out.printf("%d ", i);
		}
		System.out.println("");
		for(int i=0;i<11;i++) {
			System.out.printf("%d ", i * 10);
		}
		System.out.println("");
		for(int i=5;i>0;i--) {
			System.out.printf("%d ", i);
		}
		System.out.println("");
		for(int i=10000;i>0;i/=10) {
			System.out.printf("%d ", i);
		}
	}

}
