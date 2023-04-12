package ch04.test;

import java.util.Scanner;

public class Exam_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			paintMainMenu();
			int num = sc.nextInt();
			switch(num) {
				case 1: 
					System.out.println("1. 전체일정보기 를 선택했습니다.\n");
					break;
				case 2: 
					System.out.println("2. 일정등록 을 선택했습니다.\n");
					break;
				case 3: 
					System.out.println("3. 일정검색 을 선택했습니다.\n");
					break;
				case 4: 
					System.out.println("4. 일정삭제 를 선택했습니다.\n");
					break;
				case 0: 
					System.out.println("프로그램을 종료합니다.");
					return; // System.exit(0);
				default: 
					System.out.println("없는 번호입니다. 다시 선택하세요.\n");
					break;
			}
		}
	}
	
	private static void paintMainMenu() {
		System.out.println("[일정관리]\n1. 전체일정보기\n2. 일정등록\n3. 일정검색\n4. 일정삭제\n0. 종료");
		System.out.print("* 번호 선택: ");
	}

}
