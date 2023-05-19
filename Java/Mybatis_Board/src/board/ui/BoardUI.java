package board.ui;

import java.util.ArrayList;
import java.util.Scanner;

import board.service.BoardService;
import board.vo.Board;
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
				case "4": write(); break;
				case "5": list(); break;
				case "6": post(); break; 
				case "7": search(); break; 
				case "8": delete(); break; 
				case "9": update(); break; 
				
				case "0": exit(); return;
				default: System.out.println("선택 오류");
			}
		}
	}

	

	// 메뉴 출력 메소드
	void mainMenu() {
		// 메인메뉴 출력
		System.out.println();
		System.out.println("[ 사용자 게시판 ]");
		if(this.loginId == null) {
			System.out.println("1. 가입");
			System.out.println("2. 로그인");
		} else {
			System.out.println(this.loginId + "님 로그인 중");
			System.out.println("3. 로그아웃");
			System.out.println("4. 글쓰기");
			System.out.println("5. 글 목록");
			System.out.println("6. 글 읽기");
			System.out.println("7. 글 검색");
			System.out.println("8. 글 삭제");
			System.out.println("9. 글 수정");
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
	
	// 글쓰기 메소드
	void write() {
		// TODO 글 제목, 내용 입력받아 db에 저장.
		System.out.println("[글쓰기]");
		System.out.print("제목 입력: ");
		String title = sc.nextLine();
		System.out.print("내용 입력: ");
		String contents = sc.nextLine();
		
		Board board = new Board();
		board.setId(this.loginId);
		board.setTitle(title);
		board.setContents(contents);
		
		int cnt = service.createPost(board);
		if(cnt == 1) {
			System.out.println("저장되었습니다.");
			return;
		}
		System.out.println("가입 실패");
	}
	// 글 목록 메소드
	void list() {
		System.out.println("[글 목록]");
		ArrayList<Board> list = service.getPosts();
		System.out.println("번호\t작성자\t제목\t작성일");
		System.out.println("------------------------------------");
		if(list.size() == 0) {
			System.out.println("게시글이 없습니다");
			return;
		}
		for(Board b : list) {
			System.out.printf("%d\t%s\t%s\t%s\n", b.getNum(), b.getName(), b.getTitle(), b.getInputdate());
			System.out.println("------------------------------------");
		}
	}
	
	private void post() {
		// TODO 글 읽기 - 글번호 입력받아 해당 글 내용출력;
		if(this.loginId == null) {
			System.out.println("\n잘못된 접근입니다.\n");
			return;
		}
		System.out.println("[글 읽기]");
		System.out.print("글 번호 입력: ");
		int n = Integer.parseInt(sc.nextLine());
		Board b = service.getPost(n);
		if(b != null) {
			System.out.printf("%d\t%s\t%s\t%s\t%s\n", b.getNum(), b.getTitle(), b.getContents(), b.getName(), b.getInputdate());
			return;
		}
		System.out.println("해당 글이 존재하지 않습니다.");
		
	}
	private void search() {
		// TODO 게시판 검색 - 단어 입력받아 제목이나 내용에 포함되어있는 글 목록 출력(대소문자 무시);
		if(this.loginId == null) {
			System.out.println("\n잘못된 접근입니다.\n");
			return;
		}
		System.out.println("[글 검색]");
		System.out.printf("검색할 단어 입력: ");
		String word = sc.nextLine();
		ArrayList<Board> list = service.searchByWord(word);
		if(list.size() != 0) {
			System.out.println("---------------------------");
			System.out.println(word + "검색 결과");
			System.out.println("---------------------------");
			for(Board b : list) {
				System.out.printf("%d\t%s\t%s\t%s\n", b.getNum(), b.getTitle(), b.getName(), b.getInputdate());
				System.out.println("---------------------------");
			}
			return;
		}
		System.out.println("해당 단어가 포함된 글이 존재하지 않습니다.");
		
	}

	private void delete() {
		// TODO 삭제 - 글 번호 입력받아 본인 글만 삭제
		if(this.loginId == null) {
			System.out.println("\n잘못된 접근입니다.\n");
			return;
		}
		System.out.println("[글 삭제]");
		System.out.print("삭제할 글 번호 입력: ");
		int n = Integer.parseInt(sc.nextLine());
		if(service.deletePost(n, this.loginId)) System.out.println("삭제되었습니다");
		else System.out.println("삭제하지 못했습니다. 글번호를 확인해주세요");
		return;
		
	}
	private void update() {
		// TODO 수정 - 글 번호 입력 -> 해당게시물 출력 -> 본인 글일 경우 제목/내용 입력받아 수정
		if(this.loginId == null) {
			System.out.println("\n잘못된 접근입니다.\n");
			return;
		}
		System.out.println("[글 수정]");
		System.out.print("수정할 글 번호 입력: ");
		int n = Integer.parseInt(sc.nextLine());

		// 게시글 출력
		Board b = service.getPost(n);
		if(b == null) {
			System.out.println("해당 글이 존재하지 않습니다.");
			return;
		} else System.out.printf("%d\t%s\t%s\t%s\t%s\n", b.getNum(), b.getTitle(), b.getContents(), b.getName(), b.getInputdate());
		if(b.getId().equals(this.loginId)) {
			System.out.print("수정할 제목 입력: ");
			String newTitle = sc.nextLine();
			System.out.print("수정할 내용 입력: ");
			String newContents = sc.nextLine();
			b.setTitle(newTitle);
			b.setContents(newContents);
			if(service.updatePost(b)) System.out.println("수정되었습니다");
			else System.out.println("수정하지 못했습니다.");
			return;
		}
		
		
	}

	
	
	// 프로그램 종료 메소드
	void exit() {
		System.out.println("[로그아웃]");
		System.out.println("프로그램을 종료합니다.");
	}
}
