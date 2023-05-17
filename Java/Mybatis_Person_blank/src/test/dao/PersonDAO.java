package test.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.vo.Person;

/**
 * DB���� ó�� Ŭ����
 */
public class PersonDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // ���̹�Ƽ�� ��ü
	
	//ȸ������ ����
	public void insertPerson(Person p) {
		SqlSession ss = null;
		
		try {
			ss = factory.openSession();
			PersonMapper mapper = ss.getMapper(PersonMapper.class);
			mapper.insertPerson(p);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
	}

	public int deletePerson(int n) {
		// TODO ȸ������ �������
		SqlSession ss = null;
		int cnt = 0;
				
		try {
			ss = factory.openSession();
			PersonMapper mapper = ss.getMapper(PersonMapper.class);
			cnt = mapper.deletePerson(n);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return cnt;
	}

	public int updatePerson(Person p) {
		// TODO ����
		SqlSession ss = null;
		int cnt = 0;
				
		try {
			ss = factory.openSession();
			PersonMapper mapper = ss.getMapper(PersonMapper.class);
			cnt = mapper.updatePerson(p);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return cnt;
	}

	public Person selectOne(int n) {
		// TODO 1�� ��ȸ
		Person p = null;
		SqlSession ss = factory.openSession();
		PersonMapper m = ss.getMapper(PersonMapper.class);
		p = m.selectOnePerson(n);
		ss.close();
		
		return p;
	}
	
	public ArrayList<Person> selectAll() {
		// TODO �ٰ���ȸ
		ArrayList<Person> peopleList = null;
		SqlSession ss = null;
		try {
			ss = factory.openSession();
			PersonMapper m = ss.getMapper(PersonMapper.class);
			peopleList = m.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ss != null) ss.close();
		}
		return peopleList;
	}

	public ArrayList<Person> findByName(String name) {
		ArrayList<Person> list = null;
		SqlSession ss = null;
		try {
			ss = factory.openSession();
			PersonMapper m = ss.getMapper(PersonMapper.class);
			list = m.findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ss != null) ss.close();
		}
		return list;
	}
}
