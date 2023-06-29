package net.softsociety.spring5.dao;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;
import net.softsociety.spring5.domain.Board;

@Mapper
public interface BoardDAO {

  public ArrayList<Board> getList();

  public int writeBoard(Board b);

  public Board getBoard(int boardnum);

}
