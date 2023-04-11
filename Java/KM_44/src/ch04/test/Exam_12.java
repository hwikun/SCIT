package ch04.test;

import java.util.Scanner;

public class Exam_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("태어난 해를 입력하세요: ");
		int year = sc.nextInt();
		String zodiac = "";
		switch((year - 3) % 12) {
			case 1: zodiac = "쥐"; break;
			case 2: 
				zodiac = "소";
				break;
			case 3: 
				zodiac = "호랑이";
				break;
			case 4: 
				zodiac = "토끼";
				break;
			case 5: 
				zodiac = "용";
				break;
			case 6: 
				zodiac = "뱀";
				break;
			case 7: 
				zodiac = "말";
				break;
			case 8: 
				zodiac = "양";
				break;
			case 9: 
				zodiac = "원숭이";
				break;
			case 10: 
				zodiac = "닭";
				break;
			case 11: 
				zodiac = "개";
				break;
			case 0: 
				zodiac = "돼지";
				break;
		}
		System.out.printf("%d년생은 %s띠 입니다", year, zodiac);
	}

}
