package test.ui;

import java.util.ArrayList;
import java.util.Scanner;

import test.dao.PersonDAO;
import test.vo.Person;

public class TestMain {

	public static void main(String[] args) {
		PersonDAO dao = new PersonDAO();

/**
 * 20230516 �������� mybatis CRUD
 */

//---�Է�
//		Person pe;
//		pe = new Person("��ö��", 23);
//		dao.insertPerson(pe);

// --- ����
//		int n = 1;
//		if(dao.deletePerson(n) == 0) {
//			System.out.println(n + "�� ȸ���� �����ϴ�");
//		}
//		else {
//			System.out.println("�����Ǿ����ϴ�.");
//		}

// --- ����
//		Person p = new Person(2, "��ö��", 40);
//		int n = dao.updatePerson(p);
//		System.out.println(n + "�� �����Ϸ�");
//// --- 1����ȸ
//		Person p = dao.selectOne(2);
//		System.out.println(p);
		
// --- �ٰ� ��ȸ
//		ArrayList<Person> a = dao.selectAll();
//		System.out.println(a);
		
// --- �̸����� �˻�
		String name;
		//Ű����� ���ڿ� �Է�
		Scanner sc = new Scanner(System.in);
		System.out.printf("�˻��� �̸�: ");
		name = sc.nextLine();
		// �׹��ڿ��� ���Ե� �˻�
		ArrayList<Person> a = dao.findByName(name);
		for(Person p : a) {
			System.out.println(p);
		}
	}
	
}
