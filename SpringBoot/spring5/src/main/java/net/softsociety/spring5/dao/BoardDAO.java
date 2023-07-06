package net.softsociety.spring5.dao;

import java.util.ArrayList;
import java.util.HashMap;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import net.softsociety.spring5.domain.Board;

@Mapper
public interface BoardDAO {

  public ArrayList<Board> getList();

  public int writeBoard(Board b);

  public Board getBoard(int boardnum);

  public int hitsCountUp(int boardnum);

  public int deleteBoard(HashMap<String, Object> map);

  public int updateBoard(Board b);

  public ArrayList<Board> getList(RowBounds rb);

  public ArrayList<Board> searchBoards(RowBounds rb, HashMap<String, String> map);

  public int getTotal(HashMap<String, String> map);


}
