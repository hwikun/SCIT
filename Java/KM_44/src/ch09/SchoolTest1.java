package ch09;

import java.util.ArrayList;
import java.util.Scanner;

import ch08.A;
import ch08.school.Student;

public class SchoolTest1 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		// 학생 정보를 반복적으로 입력받아 저장;
		loop:
		while(true) {
			// 학생의 이름, 학번, 전화번호, 국영수 성적 입력받아 Student 객체 타입으로 ArrayList에 저장;
			System.out.printf("이름: ");
			String name = sc.nextLine();
			System.out.printf("학번: ");
			String id = sc.nextLine();
			System.out.printf("전화번호: ");
			String phone = sc.nextLine();
			System.out.printf("국어: ");
			int 국어 = sc.nextInt();
			System.out.printf("영어: ");
			int 영어 = sc.nextInt();
			System.out.printf("수학: ");
			int 수학 = sc.nextInt();
			
			Student s = new Student(name, id, phone, 국어, 영어, 수학);
			list.add(s);
			
			// y 입력하면 계속, n 입력하면 종료;
			while(true) {
				System.out.print("계속 입력하시겠습니까? (y/n): ");
				String a = sc.next();
				if(a.equals("y")) {
					sc.nextLine();
					continue loop;
				}
				else if (a.equals("n")) break loop;
				else {
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
					continue;
				}
			}
			
		}
		// 모든 학생정보출력;
//		System.out.println(list);
		// 학번 이름 총점 평균
		for(Student s : list) {
			System.out.printf("%s %s %d %.2f\n", s.getId(), s.getName(), s.getTotal(), s.getAvg());
		}
		
		// 전체 학생의 평균점수
		double avg = 0.0;
		for(Student s : list) {
			avg += s.getAvg();
		}
		avg /= list.size();
		System.out.printf("전체 평균점수: %.2f", avg);
	}
	
	
}
