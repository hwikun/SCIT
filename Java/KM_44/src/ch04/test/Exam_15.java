package ch04.test;

public class Exam_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<6;i++) {
			for(int j=i;j<i+5;j++) {
				System.out.printf("%d ", j);
			}
			System.out.println("");
		}
		System.out.println("----------");
		for(int i=0;i<5;i++) {
			for(int j=0;j<i+1;j++) {
				System.out.printf("%d ", j);
			}
			System.out.println("");
		}
		System.out.println("----------");
		for(int i=1;i<6;i++) {
			for(int j=i;j<6;j++) {
				System.out.printf("%d ", j);
			}
			System.out.println("");
		}
		System.out.println("----------");
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				System.out.printf("%d ", j == i ? i : 0);
			}
			System.out.println("");
		}
	}

}
