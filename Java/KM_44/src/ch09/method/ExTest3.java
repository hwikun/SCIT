package ch09.method;

import java.util.Scanner;

public class ExTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = new int[5];
		Scanner sc = new Scanner(System.in);
		
		// 키보드로 정수 5개를 입력받아 배열num에 저장;
		for(int i=0; i<num.length; i++) {
			try {
			System.out.printf("정수 입력: ");
			num[i] = sc.nextInt();
			} catch(Exception e) {
//				e.printStackTrace();
				System.out.println("입력에 실패했습니다. 다시 입력해주세요");
				sc.nextLine();
				i--;
			}
		}
			
		// 배열에 저장된 값5개 출력;
		for(int el : num) {
			System.out.printf("%d ", el);
		}
		System.out.println();
	}

}
