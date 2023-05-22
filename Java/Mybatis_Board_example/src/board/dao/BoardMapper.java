package board.dao;

import java.util.ArrayList;

import board.vo.Board;
import board.vo.Member;

public interface BoardMapper {
	//ȸ�� ����
	public int insertMember(Member m);
	//ȸ������ ��ȸ
	public Member getMember(String id);
	//�۾���
	public int insertBoard(Board board);
	//�۸��
	public ArrayList<Board> selectBoard();
	//���б�
	public Board getBoard(int num);
	//�˻�
	public ArrayList<Board> search(String keyword);
	//�ۻ���
	public int deleteBoard(Board board);
	//�ۼ���
	public int updateBoard(Board board);
}
