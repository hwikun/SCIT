package board.service;

import java.util.ArrayList;

import board.dao.BoardDAO;
import board.vo.Board;
import board.vo.Member;

public class BoardService {
	BoardDAO dao = new BoardDAO();
	
	//가입
	public int join(Member m) {
		return dao.insertMember(m);	
	}
	
	//로그인
	public boolean login(Member m) {
		Member result = dao.getMember(m.getId());
		if (result != null && result.getPassword().equals(m.getPassword()))
			return true;
		else
			return false;
	}
	
	//ID 중복확인
	public boolean idcheck(String id) {
		return dao.getMember(id) == null;
	}

	//글 저장
	public int write(Board board) {
		return dao.insertBoard(board);
	}
	
	//글목록
	public ArrayList<Board> list() {
		return dao.selectBoard();
	}

	//글읽기
	public Board read(int num) {
		return dao.getBoard(num);
	}

	//검색
	public ArrayList<Board> search(String keyword) {
		return dao.search(keyword);
	}

	//글삭제
	public int delete(Board board) {
		return dao.deleteBoard(board);
	}

	//글수정
	public int update(Board board) {
		return dao.updateBoard(board);
	}
	
}
