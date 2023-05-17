package test.ui;

import java.util.ArrayList;
import java.util.Scanner;

import test.dao.PersonDAO;
import test.vo.Person;

public class TestMain {

	public static void main(String[] args) {
		PersonDAO dao = new PersonDAO();

/**
 * 20230516 수업내용 mybatis CRUD
 */

//---입력
//		Person pe;
//		pe = new Person("윤철수", 23);
//		dao.insertPerson(pe);

// --- 삭제
//		int n = 1;
//		if(dao.deletePerson(n) == 0) {
//			System.out.println(n + "번 회원이 없습니다");
//		}
//		else {
//			System.out.println("삭제되었습니다.");
//		}

// --- 수정
//		Person p = new Person(2, "이철수", 40);
//		int n = dao.updatePerson(p);
//		System.out.println(n + "건 수정완료");
//// --- 1건조회
//		Person p = dao.selectOne(2);
//		System.out.println(p);
		
// --- 다건 조회
//		ArrayList<Person> a = dao.selectAll();
//		System.out.println(a);
		
// --- 이름으로 검색
		String name;
		//키보드로 문자열 입력
		Scanner sc = new Scanner(System.in);
		System.out.printf("검색할 이름: ");
		name = sc.nextLine();
		// 그문자열이 포함된 검색
		ArrayList<Person> a = dao.findByName(name);
		for(Person p : a) {
			System.out.println(p);
		}
	}
	
}
