package ch03.test;

import java.util.Scanner;

public class Exam_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("나이: ");
		int age = sc.nextInt();
		System.out.print("키: ");
		double height = sc.nextDouble();
		
		System.out.printf("이름은 %s이고 나이는 %d세, 키는 %.1fcm 입니다", name, age, height);
	}

}
