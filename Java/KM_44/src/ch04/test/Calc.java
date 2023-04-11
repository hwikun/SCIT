package ch04.test;

import java.util.Scanner;

public class Calc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 입력 받기
		Scanner sc = new Scanner(System.in);
		System.out.print("수식을 입력하세요(ex: 10,2,+ ): ");
		String arr[] = sc.nextLine().split(",");
		int a = Integer.parseInt(arr[0]), b = Integer.parseInt(arr[1]);
		double result = 0;
		char operator = arr[2].charAt(0);
		switch(operator) {
			case '+': result = a + b; break;
			case '-': result = a - b; break;
			case '*': result = a * b; break;
			case '/': result = (double)a / b; break;
		}// switch
		System.out.printf("%d %c %d = %.1f", a, operator, b, result);
	}

}
