package ch08.test;

import java.util.Scanner;

public class Exam_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i; 
		double d;
		String s1, s2;
		
		System.out.print("문자열: ");
		s1 = sc.next();
		System.out.print("정수: ");
		i = sc.nextInt();
		System.out.printf("실수: ");
		d = sc.nextDouble();
		System.out.print("문자열: ");
		s2 = sc.next();
		
		System.out.println(s1 + ", " + i + ", " + d + ", " + s2);
	}

}
