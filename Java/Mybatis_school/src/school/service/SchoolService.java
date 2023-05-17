package school.service;

import java.util.ArrayList;

import school.dao.SchoolDAO;
import school.vo.Student;

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
	
	public int deleteStudent(String id) {
		int result = dao.deleteItem(id);
		return result;
	}

	//검색
	// 검색할 이름: "ㄹㄹㄹ" // 이름의 일부만 입력해도 검색되게;
	// 학번, 성적으로 상세조건 선택하여 검색하게;
	
	// return ArrayList;
	
	public ArrayList<Student> searchStudent(String name) {
		// TODO Auto-generated method stub
		ArrayList<Student> studentList = dao.search(name);
		return studentList;
	}
	
	public Student searchStudentById(String id) {
		return dao.getOne(id);
		
	}

	public void updateStudent(String id, String name, String phone, String k, String e, String m) {
		// TODO Student 객체 만들기
		int kor = Integer.parseInt(k);
		int eng = Integer.parseInt(e);
		int mat = Integer.parseInt(m);
		Student s = new Student();
		// 새객체에 업데이트 된 값 할당.
		s.setId(id);
		s.setName(name);
		s.setPhone(phone);
		s.setKor(kor);
		s.setEng(eng);
		s.setMat(mat);
		int result = dao.updateItem(s);
		if(result > 0) {
			System.out.println(result + "건 업데이트 완료");
		
		}
		
		
	}

	
	
	

}
