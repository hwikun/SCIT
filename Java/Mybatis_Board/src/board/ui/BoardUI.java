package board.ui;

import java.util.Scanner;

import board.service.BoardService;
import board.vo.Member;

public class BoardUI {
	Scanner sc = new Scanner(System.in);
	BoardService service = new BoardService();
	String choice;
	String loginId;
	
	public BoardUI() {
		while (true) {
			// 메인 메뉴출력
			mainMenu();
			choice = sc.nextLine();
			switch(choice) {
				case "1": signUp(); break;
				case "2": signIn(); break;
				case "3": signOut(); break;
				case "4": signOut(); break;
				case "5": signOut(); break;
				case "0": exit(); return;
				default: System.out.println("선택 오류");
			}
		}
	}
	
	// 메뉴 출력 메소드
	void mainMenu() {
		// 메인메뉴 출력
		if(this.loginId == null) {
			System.out.println("[ 사용자 게시판 ]");
			System.out.println("1. 가입");
			System.out.println("2. 로그인");
		} else {
			System.out.println("3. 로그아웃");
			System.out.println("4. 글쓰기");
			System.out.println("5. 글 목록");
		}
		System.out.println("0. 종료");
		System.out.println();
		System.out.printf("선택 > ");
	}
	// 가입 메소드
	void signUp() {
		if(this.loginId != null) {
			System.out.println("\n잘못된 접근입니다.\n");
			return;
		}
		System.out.println();
		System.out.println("[회원 가입]");
		System.out.print("아이디 입력(10자이내): ");
		String id = sc.nextLine();
		System.out.print("패스워드 입력: ");
		String password = sc.nextLine();
		System.out.print("이름 입력: ");
		String name = sc.nextLine();
		Member m = new Member(id, password, name);
		int cnt = service.join(m);
		if(cnt == 1) {
			System.out.println("회원가입 되었습니다.");
			return;
		}
		System.out.println("가입 실패");		
	}
	// 로그인 메소드
	void signIn() {
		if(this.loginId != null) {
			System.out.println("\n잘못된 접근입니다.\n");
			return;
		}
		System.out.println();
		System.out.println("[로그인]");
		System.out.print("아이디: ");
		String id = sc.nextLine();
		System.out.print("패스워드: ");
		String password = sc.nextLine();
		System.out.println();
		Member m = new Member();
		m.setId(id);
		m.setPassword(password);
		if(service.signIn(m)) {
			this.loginId = id;
			System.out.println("환영합니다 " + this.loginId + "님!\n");
		} else {
			System.out.println("ID 또는 비밀번호가 틀립니다.");
		}
		
	}
	
	void signOut() {
		if(this.loginId != null) {
			this.loginId = null;
			System.out.println("\n로그아웃 되었습니다\n");
		} else System.out.println("\n잘못된 접근입니다.\n");
	}
	// 프로그램 종료 메소드
	void exit() {
		System.out.println("[로그아웃]");
		System.out.println("프로그램을 종료합니다.");
	}
}
