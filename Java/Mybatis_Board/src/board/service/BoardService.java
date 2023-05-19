package board.service;

import java.util.ArrayList;

import board.dao.BoardDAO;
import board.vo.Board;
import board.vo.Member;

public class BoardService {
	BoardDAO dao = new BoardDAO();

	public int join(Member m) {
		// TODO Auto-generated method stub
		int result = dao.createMember(m);
		return result;
	}

	public boolean signIn(Member m) {
		// TODO Auto-generated method stub
		Member result = dao.getMember(m);
		if(result.getPassword().equals(m.getPassword())) {
			return true;
		}
		return false;
	}

	public int createPost(Board board) {
		// TODO Auto-generated method stub
		int result = dao.insertPost(board);
		return result;
	}

	public ArrayList<Board> getPosts() {
		// TODO Auto-generated method stub
		ArrayList<Board> list = null;
		list = dao.selectAll();
		return list;
	}

	public Board getPost(int n) {
		// TODO Auto-generated method stub
		Board result = null;
		result = dao.getPost(n);
		return result;
	}

	public ArrayList<Board> searchByWord(String word) {
		// TODO Auto-generated method stub
		ArrayList<Board> list = null;
		list = dao.selectByWord(word);
		return list;
	}

	public boolean deletePost(int n, String loginId) {
		// TODO Auto-generated method stub
		boolean result = false;
		Board b = this.getPost(n);
		if(b != null && b.getId().equals(loginId)) {
			result = dao.deletePost(n);
		}
		return result;
	}

	public boolean updatePost(Board b) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = dao.updatePost(b);
		return result;
	}

}
