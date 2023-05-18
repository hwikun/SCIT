package board.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.vo.Member;

public class BoardDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체

	public int createMember(Member m) {
		// TODO Auto-generated method stub
		SqlSession ss = null;
		int result = 0;
		
		try {
			ss = factory.openSession();
			MemberMapper mapper = ss.getMapper(MemberMapper.class);
			result = mapper.insertMember(m);
			ss.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			if (ss != null) ss.close();
			
		}
		return result;
	}

	public Member getMember(Member m) {
		// TODO Auto-generated method stub
		SqlSession ss = null;
		Member result = null;
		
		try {
			ss = factory.openSession();
			MemberMapper mapper = ss.getMapper(MemberMapper.class);
			result = mapper.selectMember(m.getId());
			if (result != null) return result;
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			if (ss != null) ss.close();
			
		}
		return result;
	}

	
}
