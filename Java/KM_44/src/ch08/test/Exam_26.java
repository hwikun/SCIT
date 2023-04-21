package ch08.test;

import java.util.Scanner;

// user로부터 String을 입력받아 출력. 거꾸로 출력.
public class Exam_26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("문자열 입력: ");
		String s = sc.nextLine();
		
		System.out.println(s);
		for(int i=s.length(); i>0; i--) {
			System.out.print(s.charAt(i-1));
		}
		System.out.println();
		StringBuffer sb = new StringBuffer(s);
		System.out.print(sb.reverse());
		
		String a = new String();
		StringBuffer b = new StringBuffer();
		a += "a";
		a = a.concat("b"); // 새 String 객체 생성후 재할당;
		
		b = b.append("fasdfdf"); // 원래 String 객체에 직접 추가;
	}

}
