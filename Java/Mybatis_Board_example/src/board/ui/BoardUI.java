package board.ui;

import java.util.ArrayList;
import java.util.Scanner;

import board.service.BoardService;
import board.vo.Board;
import board.vo.Member;

//사용자 인터페이스
public class BoardUI {
	BoardService service = new BoardService();
	Scanner keyin = new Scanner(System.in);
	String loginId;			//로그인 여부. 사용자아이디 또는 null
	
	//생성자
	public BoardUI() {
		String choice;
		
		while(true) {
			menu();
			choice = keyin.nextLine();
			
			switch(choice) {
				case "1" : join(); 		break;
				case "2" : login();  	break;
				case "3" : logout();	break;
				case "4" : write();		break;
				case "5" : list();		break;
				case "6" : read();		break;
				case "7" : search();	break;
				case "8" : delete();	break;
				case "9" : update();	break;
				case "0" : exit(); 		return;
				default  : 
					System.out.println("선택 오류");
			}
		}	
	}
	
	//메뉴 출력
	void menu() {
		System.out.println();
		System.out.println("[ 사용자 게시판 ]");
		
		//로그인하지 않았을 때 보이는 메뉴
		if (this.loginId == null) {
			System.out.println("1. 가입");
			System.out.println("2. 로그인");
		}
		//로그인했을 때 보이는 메뉴
		else {	
			System.out.println("3. 로그아웃");
			System.out.println("4. 글쓰기");
			System.out.println("5. 글목록");
			System.out.println("6. 글읽기");
			System.out.println("7. 검색");
			System.out.println("8. 삭제");
			System.out.println("9. 수정");
		}
		//로그인 여부에 상관없이 보이는 메뉴
		System.out.println("0. 종료");
		System.out.print("선택>");
	}
	
	//가입
	void join() {
		System.out.println();
		System.out.println("[가입]");
		String id = null;
		
		while (true) {
			System.out.print("ID:");
			id = keyin.nextLine();
			//입력한 ID가 DB에 없으면 true -> 사용해도 됨
			if (service.idcheck(id)) break;
			System.out.println("이미 사용중인 ID입니다. 다시 입력하세요.");
		}		
		
		System.out.print("비밀번호:");
		String password = keyin.nextLine();
		System.out.print("이름:");
		String name = keyin.nextLine();
		
		Member m = new Member(id, name, password);
		
		int cnt = service.join(m);
		if (cnt == 1) 
			System.out.println("가입 완료되었습니다.");
		else
			System.out.println("가입 실패");
	}
	
	//로그인
	void login() {
		System.out.println();
		System.out.println("[로그인]");
		
		System.out.print("ID:");
		String id = keyin.nextLine();
		
		System.out.print("Password:");
		String password = keyin.nextLine();
		
		Member m = new Member();
		m.setId(id);
		m.setPassword(password);
		
		//입력한 ID와 비밀번호가 맞으면 loginId 변수에 아이디를 저장한다. 
		if (service.login(m)) {
			this.loginId = id;
		}
		//입력한 ID와 비밀번호가 틀리면 로그인 실패
		else {
			System.out.println("ID 또는 비밀번호가 틀립니다.");
		}
	}
	
	//로그아웃
	void logout() {
		if (loginId == null) return;
		
		this.loginId = null;
		System.out.println("로그아웃");
	}
	
	//글쓰기
	void write() {
		if (loginId == null) return;
		
		//글 제목, 내용 입력받아 DB에 저장
		System.out.println();
		System.out.println("[ 글쓰기 ]");
		System.out.print("제목:");
		String title = keyin.nextLine();
		System.out.print("본문:");
		String contents = keyin.nextLine();
		
		Board board = new Board();
		board.setTitle(title);
		board.setContents(contents);
		board.setId(loginId);
		
		service.write(board);
		System.out.println("저장되었습니다.");
	}
	
	//글 목록
	void list() {
		if (loginId == null) return;
		
		System.out.println();
		System.out.println("[글목록]");
		ArrayList<Board> list = service.list();
		
		if (list == null || list.size() == 0) {
			System.out.println("글이 없습니다.");
		}
		else {
			System.out.println("번호\t작성자\t작성일\t제목");
			for (Board b : list) {
				System.out.println(b.getNum() + "\t" + b.getName() + "\t" + b.getInputdate() + "\t" + b.getTitle());
			}
		}
	}
	
	//글 1개 읽기
	void read() {
		if (loginId == null) return;
		
		System.out.println();
		System.out.println("[글읽기]");
		System.out.print("글번호:");
		int num = 0;
		try {
			num = Integer.parseInt(keyin.nextLine());
		}
		catch (Exception e) {
			System.out.println("번호를 숫자로 입력하세요.");
			return;
		}
		Board board = service.read(num);
		
		if (board == null) {
			System.out.println("해당 번호의 글이 없습니다.");
		}
		else {
			System.out.println("번호:" + board.getNum());
			System.out.println("작성자:" + board.getId());
			System.out.println("작성일:" + board.getInputdate());
			System.out.println("제목:" + board.getTitle());
			System.out.println("내용:" + board.getContents());
		}
	}
	
	//게시판 검색
	void search() {
		if (loginId == null) return;
		
		System.out.println();
		System.out.println("[검색]");
		System.out.print("검색어:");
		String keyword = keyin.nextLine();
		
		ArrayList<Board> list = service.search(keyword);
		
		if (list == null || list.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		}
		else {
			System.out.println("번호\t작성자\t작성일\t제목");
			for (Board b : list) {
				System.out.println(b.getNum() + "\t" + b.getName() + "\t" + b.getInputdate() + "\t" + b.getTitle());
			}
			System.out.println("총 " + list.size() + "개의 글이 검색되었습니다.");
		}
	}
	
	//본인 글 삭제
	void delete() {
		if (loginId == null) return;
		
		System.out.println();
		System.out.println("[삭제]");
		System.out.print("삭제할 글번호:");
		
		int num = 0;
		try {
			num = Integer.parseInt(keyin.nextLine());
		}
		catch (Exception e) {
			System.out.println("번호를 숫자로 입력하세요.");
			return;
		}
		
		Board board = new Board();
		board.setNum(num);
		board.setId(loginId);
		
		int n = service.delete(board);	
		if (n == 0) {
			System.out.println("해당 번호의 글이 없습니다.");
		}
		else {
			System.out.println("삭제되었습니다.");
		}
	}
	
	//본인 글 수정
	void update() {
		if (loginId == null) return;
		
		System.out.println();
		System.out.println("[수정]");
		System.out.print("수정할 글번호:");
		int num = 0;
		try {
			num = Integer.parseInt(keyin.nextLine());
		}
		catch (Exception e) {
			System.out.println("번호를 숫자로 입력하세요.");
			return;
		}
		
		//입력한 번호의 글 조회한 후, 글이 없거나 본인글이 아니면 수정 불가
		Board board = service.read(num);
		if (board == null || !loginId.equals(board.getId())) {
			System.out.println("수정할 수 없습니다");
			return;
		}
		
		//기존 내용 출력
		System.out.println("-------------------------------------");
		System.out.println("번호:" + board.getNum());
		System.out.println("작성자:" + board.getId());
		System.out.println("작성일:" + board.getInputdate());
		System.out.println("제목:" + board.getTitle());
		System.out.println("내용:" + board.getContents());
		System.out.println("-------------------------------------");
		
		System.out.print("수정할 제목:");
		String title = keyin.nextLine();
		System.out.print("수정할 내용:");
		String contents = keyin.nextLine();
		
		board.setTitle(title);
		board.setContents(contents);
		
		int n = service.update(board);
		if (n == 0) {
			System.out.println("수정 실패");
		}
		else {
			System.out.println("수정 완료");
		}
	}
	
	//프로그램 종료
	void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
	
}
