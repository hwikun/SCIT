package net.softsociety.spring5.service;

import java.util.ArrayList;
import java.util.HashMap;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.softsociety.spring5.dao.BoardDAO;
import net.softsociety.spring5.domain.Board;
import net.softsociety.spring5.util.FileService;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

  @Autowired
  BoardDAO dao;

  @Value("${spring.servlet.multipart.location}")
  String uploadPath;

  @Override
  public ArrayList<Board> getList() {
    RowBounds rb = new RowBounds(30, 10);
    ArrayList<Board> list = dao.getList(rb);
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
  public Board readBoard(int boardnum) {
    int n = dao.hitsCountUp(boardnum);
    if (n == 0)
      return null;
    Board b = dao.getBoard(boardnum);

    return b;
  }

  @Override
  public boolean deleteBoard(HashMap<String, Object> map) {
    Board b = this.getBoard((int) (map.get("boardnum")));
    FileService.deleteFile(uploadPath + "/" + b.getSavedfile());
    int n = dao.deleteBoard(map);
    return n != 0;

  }

  @Override
  public boolean updateBoard(Board b) {
    int n = dao.updateBoard(b);
    return n != 0;
  }



}
