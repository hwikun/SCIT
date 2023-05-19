package board.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.vo.Board;
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

	public int insertPost(Board board) {
		// TODO Auto-generated method stub
		SqlSession ss = null;
		int result = 0;
		
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			result = mapper.insertPost(board);
			ss.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			if (ss != null) ss.close();
			
		}
		return result;
	}

	public ArrayList<Board> selectAll() {
		// TODO Auto-generated method stub
		SqlSession ss = null;
		ArrayList<Board> list = null;
		
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			list = mapper.selectAll();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			if (ss != null) ss.close();
			
		}
		return list;
	}

	public Board getPost(int n) {
		// TODO Auto-generated method stub
		SqlSession ss = null;
		Board b = null;
		
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			b = mapper.selectOne(n);
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			if (ss != null) ss.close();
			
		}
		return b;
	}

	public ArrayList<Board> selectByWord(String word) {
		// TODO Auto-generated method stub
		SqlSession ss = null;
		ArrayList<Board> list = null;
		
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			list = mapper.selectByWord(word);
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			if (ss != null) ss.close();
			
		}
		return list;
	
	}

	public boolean deletePost(int n) {
		// TODO Auto-generated method stub
		SqlSession ss = null;
		int result = 0;
		
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			result = mapper.deleteOne(n);
			ss.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			ss.rollback();
			
		} finally {
			if (ss != null) ss.close();
			
		}
		return result == 1 ? true : false;
	}

	public boolean updatePost(Board b) {
		// TODO Auto-generated method stub
		SqlSession ss = null;
		int result = 0;
		
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			result = mapper.updateOne(b);
			ss.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			ss.rollback();
			
		} finally {
			if (ss != null) ss.close();
			
		}
		return result == 1 ? true : false;
	}

	
}
