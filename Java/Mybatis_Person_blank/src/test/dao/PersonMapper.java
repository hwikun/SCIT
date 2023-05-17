package test.dao;

import java.util.ArrayList;

import test.vo.Person;

/**
 * Mapper XML의 SQL문 사용 메서드 정의
 */
public interface PersonMapper {
	//Person객체 저장
	public int insertPerson(Person p);  // 함수 리턴타입은 처리된 행 개수.
	public int deletePerson(int n); // 삭제
	public int updatePerson(Person p); // 수정
	public Person selectOnePerson(int n);  // 1건 조회
	public ArrayList<Person> selectAll(); //다건조회
	public ArrayList<Person> findByName(String name); // 이름으로 검색
}
