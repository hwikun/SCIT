package net.softsociety.spring5.service;

import java.util.ArrayList;
import net.softsociety.spring5.domain.Board;

public interface BoardService {

  public ArrayList<Board> getList();

  public boolean writeBoard(Board b);

  public Board getBoard(int boardnum);

}
