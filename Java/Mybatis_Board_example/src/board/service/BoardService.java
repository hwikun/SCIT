package board.service;

import java.util.ArrayList;

import board.dao.BoardDAO;
import board.vo.Board;
import board.vo.Member;

public class BoardService {
	BoardDAO dao = new BoardDAO();
	
	//����
	public int join(Member m) {
		return dao.insertMember(m);	
	}
	
	//�α���
	public boolean login(Member m) {
		Member result = dao.getMember(m.getId());
		if (result != null && result.getPassword().equals(m.getPassword()))
			return true;
		else
			return false;
	}
	
	//ID �ߺ�Ȯ��
	public boolean idcheck(String id) {
		return dao.getMember(id) == null;
	}

	//�� ����
	public int write(Board board) {
		return dao.insertBoard(board);
	}
	
	//�۸��
	public ArrayList<Board> list() {
		return dao.selectBoard();
	}

	//���б�
	public Board read(int num) {
		return dao.getBoard(num);
	}

	//�˻�
	public ArrayList<Board> search(String keyword) {
		return dao.search(keyword);
	}

	//�ۻ���
	public int delete(Board board) {
		return dao.deleteBoard(board);
	}

	//�ۼ���
	public int update(Board board) {
		return dao.updateBoard(board);
	}
	
}
