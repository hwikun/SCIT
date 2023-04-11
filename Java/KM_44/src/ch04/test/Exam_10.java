package ch04.test;

import java.util.Scanner;

public class Exam_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("년도를 입력하세요: ");
		int year = sc.nextInt();
//		boolean isLeap = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? true : false;
		boolean isLeap = false;
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) isLeap = true;
		System.out.printf("%d는 %s입니다", year, isLeap ? "윤년" : "평년");
		
	}

}
