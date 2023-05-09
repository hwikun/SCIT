package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import vo.Student;

public class SchoolDAO {
	
	ArrayList<Student> list;
	public static final String FILE_NAME = "school.sch";
	
	public SchoolDAO() {
		// school.sch 파일을 열기(객체 단위로 읽을수있게)
		// 파일이 없으면 ArrayList 생성
		// 있으면 저장된 ArrayList 객체를 읽어 list에 대입
		try {			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
			list = (ArrayList<Student>) in.readObject(); // 역직렬화;
			in.close();
		} catch(Exception e) {
			e.printStackTrace();
			list = new ArrayList<Student>();
		}
	}
	
	public void save() {
		// school.sch 파일 생성(객체를 저장할 수 있게)
		// 파일에 list 저장
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			out.writeObject(list); // 직렬화 필수;
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(Student student) {
		// TODO 저장소에 저장;
		list.add(student);
	}

	public ArrayList<Student> getList() {
		// TODO 저장소 반환;
		return list;
	}
	
	public boolean deleteItem(String id) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}
	// 검색
	// String으로 이름의 일부분 입력
	// 새로운 ArrayList<Student> 객체를 생성;
	// 0부터 마지막 index까지 기존 ArrayList내의 Student객체를 읽는다
	// 각 학생의 이름과 전달받은 문자열을 비교
	// 이름의 일부분이 매개변수와 일치하면 그 Student 객체를 ArrayList 에add;
	// ArrayList 를 return;
	public ArrayList<Student> search(String name){
		ArrayList<Student> result = new ArrayList<>();
		for(Student st: list) {
			if(st.getName().contains(name)) {
				result.add(st);
			}
		}
		return result;
	}
}
