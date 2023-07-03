package net.softsociety.spring5.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.softsociety.spring5.domain.Board;

public interface BoardService {

  public ArrayList<Board> getList();

  public boolean writeBoard(Board b);

  public Board getBoard(int boardnum);

  public Board readBoard(int boardnum);

  public boolean deleteBoard(HashMap<String, Object> map);

  public boolean updateBoard(Board b);

}
