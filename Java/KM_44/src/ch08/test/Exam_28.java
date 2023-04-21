package ch08.test;

import java.util.Scanner;

/**
 * 주민등록번호 입력받아 검증하고 결과 출력;
 * 990101-1234567 형태로 입력;
 * [결과]
 * - 입력 오류(글자수, 성별, -의 위)
 * or
 * - 99년 01월 01일생 남자/여자 입니다.
 */
public class Exam_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String id = "";
		
		System.out.print("주민등록번호: ");
		id = sc.nextLine();
		String year = id.substring(0, 2);
		String month = id.substring(2, 4);
		String day = id.substring(4, 6);
		
		if(id.length() != 14) {
			System.out.println("잘못된 주민등록번호 입니다.");
			return;
		}
		if(id.charAt(6) != '-') {
			System.out.println("- 가 잘못 입력되었습니다");
			return;
		}
		if(id.charAt(7) > '4' || id.charAt(7) < '1') {
			System.out.println("잘못된 성별입니다.");
			return;
		}
		String gender = id.charAt(7) == '1' || id.charAt(7) == '3' ? "남자" : "여자";
		System.out.printf("%s년 %s월 %s일생 %s입니다.", year, month, day, gender);
		
		
		
	}

}
