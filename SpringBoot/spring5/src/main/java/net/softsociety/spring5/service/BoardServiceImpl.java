package net.softsociety.spring5.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.softsociety.spring5.dao.BoardDAO;
import net.softsociety.spring5.domain.Board;

@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  BoardDAO dao;

  @Override
  public ArrayList<Board> getList() {
    ArrayList<Board> list = dao.getList();
    return list;
  }

  @Override
  public boolean writeBoard(Board b) {
    int n = dao.writeBoard(b);
    return n != 0;
  }

  @Override
  public Board getBoard(int boardnum) {
    Board b = dao.getBoard(boardnum);
    return b;
  }

  @Override
  public boolean hitsCountUp(Board b) {
    int n = dao.hitsCountUp(b);
    return n != 0;
  }

}
