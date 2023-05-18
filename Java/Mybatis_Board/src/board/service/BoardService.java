package board.service;

import board.dao.BoardDAO;
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

}
