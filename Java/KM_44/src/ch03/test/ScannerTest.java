package ch03.test;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// new = heap에 참조값을 할당해달라는 예약어
		// Scanner(읽어오고싶은 장치);
		// System.in = 표준입력(키보드);
		System.out.print("나이 입력: ");
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt(); // int type으로 변환
		System.out.println("입력한 나이는 " + age + "살 입니다");
		
		//문자열 입력은 next();	
		System.out.print("이름입력: ");
		String name = sc.next();
		System.out.println("이름은 " + name + "입니다");
		
		// 주소입력
		System.out.print("주소입력: ");
		sc.next();
		String address = sc.nextLine();
		System.out.println("주소는 " + address + "입니다");
		
	}

}
