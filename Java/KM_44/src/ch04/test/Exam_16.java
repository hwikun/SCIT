package ch04.test;

public class Exam_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp = 0;
		for(int i=1; i<=100; i++) {
			if(100 % i == 0) {
				System.out.printf("%d ", i);
				temp++;
				if (temp % 3 == 0) System.out.println("");
			}
		}
		
	}

}
