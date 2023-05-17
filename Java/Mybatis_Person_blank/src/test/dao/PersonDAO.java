package test.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.vo.Person;

/**
 * DB관련 처리 클래스
 */
public class PersonDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체
	
	//회원정보 저장
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
		// TODO 회원정보 삭제기능
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
		// TODO 수정
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
		// TODO 1건 조회
		Person p = null;
		SqlSession ss = factory.openSession();
		PersonMapper m = ss.getMapper(PersonMapper.class);
		p = m.selectOnePerson(n);
		ss.close();
		
		return p;
	}
	
	public ArrayList<Person> selectAll() {
		// TODO 다건조회
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
