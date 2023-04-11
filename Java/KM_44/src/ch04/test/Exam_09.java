package ch04.test;

import java.util.Scanner;

public class Exam_09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력: ");
		int num = sc.nextInt();
		boolean isOdd = num % 2 == 1 ? true : false;
		System.out.printf("%d: %s입니다", num, isOdd ? "홀수" : "짝수");
	}

}
