package ch04.test;

import java.util.Scanner;

public class Exam_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		while(true) {
			System.out.print("정수입력: ");
			int val1 = sc.nextInt();
			if (val1 == 0) break;
			sum += val1;
		}
		System.out.printf("합계: %d", sum);
	}

}
