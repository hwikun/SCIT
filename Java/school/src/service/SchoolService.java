package service;

import java.util.ArrayList;

import dao.SchoolDAO;
import vo.Student;

public class SchoolService {
	SchoolDAO dao = new SchoolDAO();
	
	public void inputStudent(Student student) {
		// TODO Auto-generated method stub
		dao.insert(student);
		
	}

	public ArrayList<Student> getStudentList() {
		// TODO DAO 에서 데이터 가져오기
		ArrayList<Student> studentList = dao.getList();
		return studentList;
	}
	
	public boolean deleteStudent(String id) {
		boolean result = dao.deleteItem(id);
		return result;
	}
	
	//검색
	// 검색할 이름: "ㄹㄹㄹ" // 이름의 일부만 입력해도 검색되게;
	// 학번, 성적으로 상세조건 선택하여 검색하게;
	
	// return ArrayList;
	
	

}
