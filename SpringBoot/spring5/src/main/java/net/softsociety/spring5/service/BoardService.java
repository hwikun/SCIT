package net.softsociety.spring5.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.softsociety.spring5.domain.Board;
import net.softsociety.spring5.domain.Reply;
import net.softsociety.spring5.util.PageNavigator;

public interface BoardService {

  public ArrayList<Board> getList();

  public boolean writeBoard(Board b);

  public Board getBoard(int boardnum);

  public Board readBoard(int boardnum);

  public boolean deleteBoard(HashMap<String, Object> map);

  public boolean updateBoard(Board b);

  public ArrayList<Board> getList(PageNavigator navi, String type, String searchWord);

  public PageNavigator getPageNavigator(int pagePerGroup, int countPerPage, int page, String type,
      String searchWord);

  public void createReply(Reply reply);

  public ArrayList<Reply> readallReply(int boardnum);

  public void deleteReply(Reply reply);

}
