package board.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.vo.Board;
import board.vo.Member;

public class BoardDAO {
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	//ȸ������ ����
	public int insertMember(Member m) {
		SqlSession ss = null;
		int n = 0;
		
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			n = mapper.insertMember(m);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return n;
	}

	//ȸ������ ��ȸ
	public Member getMember(String id) {
		SqlSession ss = null;
		Member member = null;
		
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			member = mapper.getMember(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return member;
	}

	//�� ����
	public int insertBoard(Board board) {
		SqlSession ss = null;
		int n = 0;
		
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			n = mapper.insertBoard(board);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return n;
	}
	
	//�۸��
	public ArrayList<Board> selectBoard() {
		SqlSession ss = null;
		ArrayList<Board> list = null;
		
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			list = mapper.selectBoard();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return list;
	}

	//���б�
	public Board getBoard(int num) {
		SqlSession ss = null;
		Board board = null;
		
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			board = mapper.getBoard(num);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return board;
	}

	//�˻�
	public ArrayList<Board> search(String keyword) {
		SqlSession ss = null;
		ArrayList<Board> list = null;
		
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			list = mapper.search(keyword);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return list;
	}

	//�ۻ���
	public int deleteBoard(Board board) {
		SqlSession ss = null;
		int n = 0;
		
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			n = mapper.deleteBoard(board);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return n;
	}

	//����
	public int updateBoard(Board board) {
		SqlSession ss = null;
		int n = 0;
		
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			n = mapper.updateBoard(board);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return n;
	}
	
}
