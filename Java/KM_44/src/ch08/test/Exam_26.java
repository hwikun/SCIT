package ch08.test;

import java.util.Scanner;

// user로부터 String을 입력받아 출력. 거꾸로 출력.
public class Exam_26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("문자열 입력: ");
		String s = sc.nextLine();
		System.out.println(s.toString());
		char[] arr = s.toCharArray();
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%c", arr[arr.length -1 -i]);
		}
		
	}

}
