package ch03.test;

import java.util.Scanner;

public class Exam_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수: ");
		int language = sc.nextInt();
		System.out.print("영어점수: ");
		int english = sc.nextInt();
		System.out.print("수학점수: ");
		int math = sc.nextInt();
		int total = language + english + math;
		double avg = total / 3.0; // 캐스팅 필수!!!
		
		System.out.printf("총점: %d 평균 %.2f", total, avg);
	}

}
