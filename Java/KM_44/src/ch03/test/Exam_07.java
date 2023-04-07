package ch03.test;

import java.util.Scanner;

public class Exam_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.printf("상품가격을 입력하세요: ");
		int price = sc.nextInt();
		int fiftyThousand = price / 50000;
		int tenThousand = (price % 50000) / 10000;
		int fiveThousand = (price % 10000) / 5000;
		int thousand = (price % 5000) / 1000;
		int remain = price % 1000;
		
		System.out.printf("%d원은 5만원권 %d장, 1만원권 %d장, 5천원권 %d장, 1천원권 %d장과 나머지 %d원이 남습니다", price, fiftyThousand, tenThousand, fiveThousand, thousand, remain);
	}

}
