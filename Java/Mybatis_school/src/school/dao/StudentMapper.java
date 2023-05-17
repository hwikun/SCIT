package school.dao;

import java.util.ArrayList;

import school.vo.Student;

public interface StudentMapper {
	public int insert(Student s);

	public ArrayList<Student> findStudents();
	
	public int deleteStudent(String id);

	public int updateStudent(Student s);

	public ArrayList<Student> findByName(String name);

	public Student findOne(String id);
}
