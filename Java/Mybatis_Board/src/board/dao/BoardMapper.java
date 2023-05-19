package board.dao;

import java.util.ArrayList;

import board.vo.Board;

public interface BoardMapper {
	public int insertPost(Board board);

	public ArrayList<Board> selectAll();

	public Board selectOne(int n);

	public ArrayList<Board> selectByWord(String word);

	public int deleteOne(int n);

	public int updateOne(Board b);
}
