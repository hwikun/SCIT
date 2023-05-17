package school.ui;

import java.util.ArrayList;
import java.util.Scanner;

import school.service.SchoolService;
import school.vo.Student;

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
		System.out.printf("학번: ");
		id = keyin.next();
		System.out.printf("이름: ");
		name = keyin.next();
		System.out.printf("전화: ");
		phone = keyin.next();
		System.out.printf("국어점수: ");
		k = keyin.nextInt();
		System.out.printf("영어점수: ");
		e = keyin.nextInt();
		System.out.printf("수학점수: ");
		m = keyin.nextInt();
		Student student = new Student(id, name, phone, k, e, m);
		service.inputStudent(student);
		System.out.println("저장되었습니다");
	}
	
	void showList() {
		// TODO 데이터 조회
		System.out.println("2. 전체 목록 출력");
		ArrayList<Student> studentList = service.getStudentList();
		for(Student st : studentList) {
			System.out.println(st);
		}
	}
	
	void searchData() {
		// TODO 데이터 검색
		System.out.println();
		System.out.println("[ 검색 방식 선택 ]");
		System.out.print("1. 이름");
		System.out.print("2. 학번");
		System.out.print("3. 성적");
		String choice = keyin.next();
		switch(choice) {
			case "1":
				System.out.printf("이름 입력: ");
				String name = keyin.next();
				ArrayList<Student> studentList = service.searchStudent(name);
				if(studentList.isEmpty()) {
					System.out.println("검색 결과가 없습니다.");
				} else {
					System.out.println("이름\t학번\t총점\t평균");
					for(Student s: studentList) {
						System.out.printf("%s\t%s\t%d\t%.2f\n", s.getName(), s.getId(), s.getTotal(), s.getAvg());;
					}
					
				}
				break;
			case "2":
				
				break;
			case "3":
				
				break;
			default: 
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
				searchData();
		}
		
	}
	
	void deleteData() {
		// TODO 데이터 삭제
		System.out.printf("학번 입력: ");
		String deleteId = keyin.nextLine();
		int result = service.deleteStudent(deleteId);
		if(result > 0) System.out.println("삭제되었습니다");
		else System.out.println("삭제에 실패했습니다. 학번을 확인해주세요");
	}
	
	void updateData() {
		// TODO 데이터 수정
		String name, id, phone, k, e, m;
		System.out.printf("학번 입력: ");
		String updateId = keyin.nextLine();
		Student s = service.searchStudentById(updateId);
		// null이면 종료
		if(s == null) {
			System.out.println("존재하지 않는 학생입니다");
		}
		//수정할 값 입력받기
		System.out.printf("학번: ");
		id = keyin.nextLine();
		System.out.printf("이름: ");
		name = keyin.next();
		System.out.printf("전화: ");
		phone = keyin.next();
		System.out.printf("국어점수: ");
		k = keyin.nextLine();
		System.out.printf("영어점수: ");
		e = keyin.nextLine();
		System.out.printf("수학점수: ");
		m = keyin.nextLine();
		service.updateStudent(id, name, phone, k, e, m);
		
		
	}
	
	void exit() {
		// TODO 프로그램 종료
	
		System.out.println("프로그램을 종료합니다");
		return;
	}
}
