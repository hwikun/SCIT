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
import net.softsociety.spring5.util.PageNavigator;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

  @Autowired
  BoardDAO dao;

  @Value("${spring.servlet.multipart.location}")
  String uploadPath;

  @Override
  public ArrayList<Board> getList() {
    RowBounds rb = new RowBounds(0, 200);
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

  @Override
  public ArrayList<Board> getList(PageNavigator navi, String type, String searchWord) {
    HashMap<String, String> map = new HashMap<>();
    map.put("type", type);
    map.put("searchWord", searchWord);
    RowBounds rb = new RowBounds(navi.getStartRecord(), navi.getCountPerPage());
    ArrayList<Board> boardlist = dao.searchBoards(rb, map);
    return boardlist;
  }

  @Override
  public PageNavigator getPageNavigator(int pagePerGroup, int countPerPage, int page, String type,
      String searchWord) {
    // 검색할 내용
    HashMap<String, String> map = new HashMap<>();
    map.put("type", type);
    map.put("searchWord", searchWord);

    int total = dao.getTotal(map);

    PageNavigator navi = new PageNavigator(pagePerGroup, countPerPage, page, total);

    return navi;
  }



}
