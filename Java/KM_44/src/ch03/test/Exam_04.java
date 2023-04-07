package ch03.test;

import java.util.Scanner;

public class Exam_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("과목1: ");
		int sub1 = sc.nextInt();
		System.out.print("과목2: ");
		int sub2 = sc.nextInt();
		System.out.print("과목3: ");
		int sub3 = sc.nextInt();
		double avg = (sub1 + sub2 + sub3) / 3.0;
		boolean result = avg > 59 && !(sub1 < 40 || sub2 < 40 || sub3 < 40);
		
		System.out.printf("평균: %.2f\n%s", avg, result ? "합격" : "불합격");
	}

}
