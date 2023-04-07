package ch03.test;

import java.util.Scanner;

public class Exam_01 {
	public static void main(String[] args) {
		System.out.print("정수를 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		boolean result = num > 0;
		System.out.printf("num의 값: %d%nresult의 값: %b", num, result);
	}
}
