package school.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import school.vo.Student;

public class SchoolDAO {
	
	ArrayList<Student> list;
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체
	
	
	public void insert(Student s) {
		// TODO 저장소에 저장;
		SqlSession ss = null;
		
		try {
			ss = factory.openSession();
			StudentMapper m = ss.getMapper(StudentMapper.class);
			m.insert(s);
			ss.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			if (ss != null) ss.close();
			
		}
	}
	
	public Student getOne(String id) {
		// 하나만 찾기
		SqlSession ss = null;
		Student s = null;
		try {
			ss = factory.openSession();
			StudentMapper m = ss.getMapper(StudentMapper.class);
			s = m.findOne(id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ss != null) ss.close();
		}
		return s;
	}

	public ArrayList<Student> getList() {
		// TODO 저장소 반환;
		SqlSession ss = null;
		ArrayList<Student> list = null;
		
		try {
			ss = factory.openSession();
			StudentMapper m = ss.getMapper(StudentMapper.class);
			list = m.findStudents();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			if (ss != null) ss.close();
			
		}
		return list;
	}
	
	public int deleteItem(String id) {
		SqlSession ss = null;
		int session = 0;
		try {
			ss = factory.openSession();
			StudentMapper m = ss.getMapper(StudentMapper.class);
			session = m.deleteStudent(id);
			ss.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			if (ss != null) ss.close();
			
		}
		return session;
	}
	
	public int updateItem(Student s) {
		SqlSession ss = null;
		int session = 0;
		try {
			ss = factory.openSession();
			StudentMapper m = ss.getMapper(StudentMapper.class);
			session = m.updateStudent(s);
			ss.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			if (ss != null) ss.close();
			
		}
		return session;
	}
	// 검색
	// String으로 이름의 일부분 입력
	// 새로운 ArrayList<Student> 객체를 생성;
	// 0부터 마지막 index까지 기존 ArrayList내의 Student객체를 읽는다
	// 각 학생의 이름과 전달받은 문자열을 비교
	// 이름의 일부분이 매개변수와 일치하면 그 Student 객체를 ArrayList 에add;
	// ArrayList 를 return;
	public ArrayList<Student> search(String name){
		SqlSession ss = null;
		ArrayList<Student> list = null;
		
		try {
			ss = factory.openSession();
			StudentMapper m = ss.getMapper(StudentMapper.class);
			list = m.findByName(name);
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			if (ss != null) ss.close();
			
		}
		return list;
	}
}
