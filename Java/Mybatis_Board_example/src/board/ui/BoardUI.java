package board.ui;

import java.util.ArrayList;
import java.util.Scanner;

import board.service.BoardService;
import board.vo.Board;
import board.vo.Member;

//����� �������̽�
public class BoardUI {
	BoardService service = new BoardService();
	Scanner keyin = new Scanner(System.in);
	String loginId;			//�α��� ����. ����ھ��̵� �Ǵ� null
	
	//������
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
					System.out.println("���� ����");
			}
		}	
	}
	
	//�޴� ���
	void menu() {
		System.out.println();
		System.out.println("[ ����� �Խ��� ]");
		
		//�α������� �ʾ��� �� ���̴� �޴�
		if (this.loginId == null) {
			System.out.println("1. ����");
			System.out.println("2. �α���");
		}
		//�α������� �� ���̴� �޴�
		else {	
			System.out.println("3. �α׾ƿ�");
			System.out.println("4. �۾���");
			System.out.println("5. �۸��");
			System.out.println("6. ���б�");
			System.out.println("7. �˻�");
			System.out.println("8. ����");
			System.out.println("9. ����");
		}
		//�α��� ���ο� ������� ���̴� �޴�
		System.out.println("0. ����");
		System.out.print("����>");
	}
	
	//����
	void join() {
		System.out.println();
		System.out.println("[����]");
		String id = null;
		
		while (true) {
			System.out.print("ID:");
			id = keyin.nextLine();
			//�Է��� ID�� DB�� ������ true -> ����ص� ��
			if (service.idcheck(id)) break;
			System.out.println("�̹� ������� ID�Դϴ�. �ٽ� �Է��ϼ���.");
		}		
		
		System.out.print("��й�ȣ:");
		String password = keyin.nextLine();
		System.out.print("�̸�:");
		String name = keyin.nextLine();
		
		Member m = new Member(id, name, password);
		
		int cnt = service.join(m);
		if (cnt == 1) 
			System.out.println("���� �Ϸ�Ǿ����ϴ�.");
		else
			System.out.println("���� ����");
	}
	
	//�α���
	void login() {
		System.out.println();
		System.out.println("[�α���]");
		
		System.out.print("ID:");
		String id = keyin.nextLine();
		
		System.out.print("Password:");
		String password = keyin.nextLine();
		
		Member m = new Member();
		m.setId(id);
		m.setPassword(password);
		
		//�Է��� ID�� ��й�ȣ�� ������ loginId ������ ���̵� �����Ѵ�. 
		if (service.login(m)) {
			this.loginId = id;
		}
		//�Է��� ID�� ��й�ȣ�� Ʋ���� �α��� ����
		else {
			System.out.println("ID �Ǵ� ��й�ȣ�� Ʋ���ϴ�.");
		}
	}
	
	//�α׾ƿ�
	void logout() {
		if (loginId == null) return;
		
		this.loginId = null;
		System.out.println("�α׾ƿ�");
	}
	
	//�۾���
	void write() {
		if (loginId == null) return;
		
		//�� ����, ���� �Է¹޾� DB�� ����
		System.out.println();
		System.out.println("[ �۾��� ]");
		System.out.print("����:");
		String title = keyin.nextLine();
		System.out.print("����:");
		String contents = keyin.nextLine();
		
		Board board = new Board();
		board.setTitle(title);
		board.setContents(contents);
		board.setId(loginId);
		
		service.write(board);
		System.out.println("����Ǿ����ϴ�.");
	}
	
	//�� ���
	void list() {
		if (loginId == null) return;
		
		System.out.println();
		System.out.println("[�۸��]");
		ArrayList<Board> list = service.list();
		
		if (list == null || list.size() == 0) {
			System.out.println("���� �����ϴ�.");
		}
		else {
			System.out.println("��ȣ\t�ۼ���\t�ۼ���\t����");
			for (Board b : list) {
				System.out.println(b.getNum() + "\t" + b.getName() + "\t" + b.getInputdate() + "\t" + b.getTitle());
			}
		}
	}
	
	//�� 1�� �б�
	void read() {
		if (loginId == null) return;
		
		System.out.println();
		System.out.println("[���б�]");
		System.out.print("�۹�ȣ:");
		int num = 0;
		try {
			num = Integer.parseInt(keyin.nextLine());
		}
		catch (Exception e) {
			System.out.println("��ȣ�� ���ڷ� �Է��ϼ���.");
			return;
		}
		Board board = service.read(num);
		
		if (board == null) {
			System.out.println("�ش� ��ȣ�� ���� �����ϴ�.");
		}
		else {
			System.out.println("��ȣ:" + board.getNum());
			System.out.println("�ۼ���:" + board.getId());
			System.out.println("�ۼ���:" + board.getInputdate());
			System.out.println("����:" + board.getTitle());
			System.out.println("����:" + board.getContents());
		}
	}
	
	//�Խ��� �˻�
	void search() {
		if (loginId == null) return;
		
		System.out.println();
		System.out.println("[�˻�]");
		System.out.print("�˻���:");
		String keyword = keyin.nextLine();
		
		ArrayList<Board> list = service.search(keyword);
		
		if (list == null || list.isEmpty()) {
			System.out.println("�˻� ����� �����ϴ�.");
		}
		else {
			System.out.println("��ȣ\t�ۼ���\t�ۼ���\t����");
			for (Board b : list) {
				System.out.println(b.getNum() + "\t" + b.getName() + "\t" + b.getInputdate() + "\t" + b.getTitle());
			}
			System.out.println("�� " + list.size() + "���� ���� �˻��Ǿ����ϴ�.");
		}
	}
	
	//���� �� ����
	void delete() {
		if (loginId == null) return;
		
		System.out.println();
		System.out.println("[����]");
		System.out.print("������ �۹�ȣ:");
		
		int num = 0;
		try {
			num = Integer.parseInt(keyin.nextLine());
		}
		catch (Exception e) {
			System.out.println("��ȣ�� ���ڷ� �Է��ϼ���.");
			return;
		}
		
		Board board = new Board();
		board.setNum(num);
		board.setId(loginId);
		
		int n = service.delete(board);	
		if (n == 0) {
			System.out.println("�ش� ��ȣ�� ���� �����ϴ�.");
		}
		else {
			System.out.println("�����Ǿ����ϴ�.");
		}
	}
	
	//���� �� ����
	void update() {
		if (loginId == null) return;
		
		System.out.println();
		System.out.println("[����]");
		System.out.print("������ �۹�ȣ:");
		int num = 0;
		try {
			num = Integer.parseInt(keyin.nextLine());
		}
		catch (Exception e) {
			System.out.println("��ȣ�� ���ڷ� �Է��ϼ���.");
			return;
		}
		
		//�Է��� ��ȣ�� �� ��ȸ�� ��, ���� ���ų� ���α��� �ƴϸ� ���� �Ұ�
		Board board = service.read(num);
		if (board == null || !loginId.equals(board.getId())) {
			System.out.println("������ �� �����ϴ�");
			return;
		}
		
		//���� ���� ���
		System.out.println("-------------------------------------");
		System.out.println("��ȣ:" + board.getNum());
		System.out.println("�ۼ���:" + board.getId());
		System.out.println("�ۼ���:" + board.getInputdate());
		System.out.println("����:" + board.getTitle());
		System.out.println("����:" + board.getContents());
		System.out.println("-------------------------------------");
		
		System.out.print("������ ����:");
		String title = keyin.nextLine();
		System.out.print("������ ����:");
		String contents = keyin.nextLine();
		
		board.setTitle(title);
		board.setContents(contents);
		
		int n = service.update(board);
		if (n == 0) {
			System.out.println("���� ����");
		}
		else {
			System.out.println("���� �Ϸ�");
		}
	}
	
	//���α׷� ����
	void exit() {
		System.out.println("���α׷��� �����մϴ�.");
	}
	
}
