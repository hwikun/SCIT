package ch04.test;

import java.util.Scanner;

public class Exam_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b, c;
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 정수 입력: ");
		a = sc.nextInt();
		System.out.print("두 번째 정수 입력: ");
		b = sc.nextInt();
		System.out.print("세 번째 정수 입력: ");
		c = sc.nextInt();
//		if (a > b && a > c) System.out.printf("%d, %d, %d 중 가장 큰 수는 %d입니다.", a, b, c, a);
//		else if (b > a && b > c) System.out.printf("%d, %d, %d 중 가장 큰 수는 %d입니다.", a, b, c, b);
//		else System.out.printf("%d, %d, %d 중 가장 큰 수는 %d입니다.", a, b, c, c);
		
		int max = a;
		if(max < b) max = b;
		if(max < c) max = c;
		System.out.printf("%d, %d, %d 중 가장 큰 수는 %d입니다.", a, b, c, max);
	}

}
