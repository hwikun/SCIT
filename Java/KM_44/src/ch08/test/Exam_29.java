package ch08.test;

import java.util.Calendar;
import java.util.Scanner;

public class Exam_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String id = "";
		
		while(true) {
			System.out.print("주민등록번호(000000-0000000): ");
			id = sc.nextLine();
			if(!id.matches("\\d{6}\\-[1-4]\\d{6}")) {
				System.out.println("잘못된 주민등록번호입니다.");
				continue;
			}
			
			String sYear = id.substring(0, 2);
			String sMonth = id.substring(2, 4);
			String sDay = id.substring(4, 6);
			char gender = id.charAt(7);
			int year = 0;
			int day = Integer.parseInt(sDay);
			
			int month = Integer.parseInt(sMonth);
			if(month > 12 || month < 1) {
				System.out.println("월은 1~12중 하나여야합니다");
				continue;
			}

			if(gender > '2') {
				year = Integer.parseInt(sYear) + 2000;
				if(year > Calendar.getInstance().get(Calendar.YEAR)) {
					System.out.println("올해보다 더 늦은 연도는 입력할 수 없습니다.");
					continue;
				}
				if(!Exam_29.cheakYear(year, month, day)) {
					continue;
				}
			} else {
				year = Integer.parseInt(sYear) + 1900;
				if(!Exam_29.cheakYear(year, month, day)) {
					continue;
				}
			}
			if(!Exam_29.verifyNum(id)) {
				System.out.println("잘못된 주민번호입니다. 번호를 다시 확인해주세요");
				continue;
			}
			System.out.printf("%d년 %d월 %d일생 만 %d세, %s입니다.", year, month, day, Exam_29.calcAge(year, month, day) );
			return;
		} // while
	}
	
	// 윤년검증
	public static boolean cheakYear(int year, int month, int day) {
		boolean isLeap = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? true : false;
		
		int maxDay = 0; // 로컬변수는 항상 사용전에 초기
		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
			maxDay = 31;
			break;
		case 4: case 6: case 9: case 11: 
			maxDay = 30;
			break;
		case 2: 
			if(isLeap) maxDay = 29;
			else maxDay = 28;
			break;
		}
		if(day > 0 && day < maxDay) {
			return true;
		}
		System.out.printf("일은 1~%d중 하나여야합니다", maxDay);
		return false;
	}
	
	// 만나이계산
	public static int calcAge(int year, int month, int day) {
		int result = 0;
		Calendar c = Calendar.getInstance();
		int currentYear = c.get(Calendar.YEAR);
		int currentMonth = c.get(Calendar.MONTH) + 1;
		int currentDay = c.get(Calendar.DATE);
		
		result = currentYear - year;
		// 생일 안지났으면 나이 하나 더 빼기
		if(month * 100 + day > currentMonth *100 + currentDay) result--;
		return result;
	}
	
	// 주민번호 검
	public static boolean verifyNum(String arr) {
		int verify = 0;
		boolean result = false;
		int sum = 0;
		int[] idArr = new int[arr.length()-1];
		for(int i=0; i<arr.length(); i++) {
			if(arr.charAt(i) != '-') {
				idArr[i] = (int)(arr.charAt(i));
			}
		}
		for(int i=0; i<idArr.length-1; i++) {
			if(i+2 < 10) sum += idArr[i] * i+2;
			else sum += idArr[i] * (i-6);
		}
		verify = sum % 11 >= 10 ? sum % 11 -10 : sum % 11 ;
		result = verify == idArr[12] ? true : false;
		return result;
		
	}

}

/**
 * 주민등록번호(000000-0000000): 111111
 * 글자수를 확인하세요
 * 주민등록번호(000000-0000000): 111111.1111111
 * '-'로 구분되어야 합니다
 * 주민등록번호(000000-0000000): 111111-abc1234
 * 숫자로 입력하세요
 * 주민등록번호(000000-0000000): 990011-1234567
 * 월은 1~12중 하나여야합니다
 * 주민등록번호(000000-0000000): 990229-1234567
 * 일은 1~28중 하나여야합니다.
 * 주민등록번호(000000-0000000): 990228-5000123
 * 성별을 확인하세요
 * 주민등록번호(000000-0000000): 990228-1234567
 * 99년 2월 28일생 만24세 입니다.
*/
