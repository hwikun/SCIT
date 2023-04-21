package ch08.test;

import java.util.Scanner;

public class Exam_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String id = "";
		
		while(true) {
			System.out.print("주민등록번호(000000-0000000): ");
			id = sc.nextLine();
			String year = id.substring(0, 2);
			String month = id.substring(2, 4);
			String day = id.substring(4, 6);
			int IGender = (int)id.charAt(7);
			String gender = !(IGender > 4 && IGender < 1) && IGender % 2 == 1 ? "남자" : "여자";
			
			if(id.length() == 14) {
				System.out.println("잘못된 주민등록번호 입니다.");
				continue;
			}
			if(id.indexOf('-') != 6) {
				System.out.println("-가 잘못 입력되었습니다");
				continue;
			}
			
		}
	}

}
