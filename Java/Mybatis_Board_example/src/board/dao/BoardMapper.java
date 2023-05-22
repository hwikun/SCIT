package board.dao;

import java.util.ArrayList;

import board.vo.Board;
import board.vo.Member;

public interface BoardMapper {
	//회원 저장
	public int insertMember(Member m);
	//회원정보 조회
	public Member getMember(String id);
	//글쓰기
	public int insertBoard(Board board);
	//글목록
	public ArrayList<Board> selectBoard();
	//글읽기
	public Board getBoard(int num);
	//검색
	public ArrayList<Board> search(String keyword);
	//글삭제
	public int deleteBoard(Board board);
	//글수정
	public int updateBoard(Board board);
}
