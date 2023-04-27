package ui;

import java.util.ArrayList;
import java.util.Scanner;

import service.SchoolService;
import vo.Student;

public class SchoolUI {
	Scanner keyin = new Scanner(System.in);
	SchoolService service = new SchoolService();
	String choice;
	
	public SchoolUI() {
		while(true) {
				mainMenu();
				choice = keyin.next();
				switch (choice) {
				case "1": inputData(); break;
				case "2": showList(); break;
				case "3": searchData(); break;
				case "4": deleteData(); break;
				case "0": exit(); return;
				default: System.out.println("선택 오류");
			}
		}
	}
	
	void mainMenu() {
		// 메인메뉴 출력
		System.out.println();
		System.out.println("[ 학생 성적 관리 ]");
		System.out.println("1. 학생 성적 입력");
		System.out.println("2. 전체 목록 출력");
		System.out.println("3. 검색");
		System.out.println("4. 삭제");
		System.out.println("0. 종료");
		System.out.println("선택 > ");
	}
	
	void inputData() {
		// TODO 데이터 입력
		System.out.println("1. 학생 성적 입력");
		String name, id, phone;
		int k, e, m;
		System.out.printf("이름: ");
		name = keyin.next();
		System.out.printf("학번: ");
		id = keyin.next();
		System.out.printf("전화: ");
		phone = keyin.next();
		System.out.printf("국어점수: ");
		k = keyin.nextInt();
		System.out.printf("영어점수: ");
		e = keyin.nextInt();
		System.out.printf("수학점수: ");
		m = keyin.nextInt();
		Student student = new Student(name, id, phone, k, e, m);
		service.inputStudent(student);
		System.out.println("저장되었습니다");
	}
	
	void showList() {
		// TODO 데이터 조회
		System.out.println("2. 전체 목록 출력");
		ArrayList<Student> studentList = service.getStudentList();
		System.out.println(studentList);
	}
	
	void searchData() {
		// TODO 데이터 검색
	}
	
	void deleteData() {
		// TODO 데이터 삭제
		System.out.printf("학번 입력: ");
		String deleteId = keyin.next();
		boolean result = service.deleteStudent(deleteId);
		if(result) System.out.println("삭제되었습니다");
		else System.out.println("삭제에 실패했습니다. 학번을 확인해주세요");
	}
	
	void exit() {
		// TODO 프로그램 종료
		System.out.println("프로그램을 종료합니다");
	}
}
