package board.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.vo.Board;
import board.vo.Member;

public class BoardDAO {
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	//회원정보 저장
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

	//회원정보 조회
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

	//글 저장
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
	
	//글목록
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

	//글읽기
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

	//검색
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

	//글삭제
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

	//수정
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
