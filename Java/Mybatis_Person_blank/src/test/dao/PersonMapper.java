package test.dao;

import java.util.ArrayList;

import test.vo.Person;

/**
 * Mapper XML�� SQL�� ��� �޼��� ����
 */
public interface PersonMapper {
	//Person��ü ����
	public int insertPerson(Person p);  // �Լ� ����Ÿ���� ó���� �� ����.
	public int deletePerson(int n); // ����
	public int updatePerson(Person p); // ����
	public Person selectOnePerson(int n);  // 1�� ��ȸ
	public ArrayList<Person> selectAll(); //�ٰ���ȸ
	public ArrayList<Person> findByName(String name); // �̸����� �˻�
}
