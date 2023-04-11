package ch04.test;
import java.util.Scanner;

public class Exam_11 {

	public static void main(String[] args) {
		// 월마다 최대 일수구하기(윤년포함)
		Scanner sc = new Scanner(System.in);
		System.out.print("년도를 입력하세요: ");
		int year = sc.nextInt();
		System.out.print("월를 입력하세요: ");
		int month = sc.nextInt();
		
		// 윤년계산
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
		default: System.out.println("다시 입력하세요");
		} // switch
		System.out.printf("%d년 %d월은 %d일 까지 있습니다.", year, month, maxDay);
	}

}
