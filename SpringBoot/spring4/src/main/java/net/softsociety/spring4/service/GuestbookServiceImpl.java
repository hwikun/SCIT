package net.softsociety.spring4.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.softsociety.spring4.dao.GuestbookDAO;
import net.softsociety.spring4.domain.Guestbook;

@Service
public class GuestbookServiceImpl implements GuestbookService {

  @Autowired
  GuestbookDAO dao;

  @Override
  public int insert(Guestbook guestbook) {
    int n = dao.insert(guestbook);
    return n;
  }

  @Override
  public ArrayList<Guestbook> findAll() {
    ArrayList<Guestbook> list = dao.findAll();
    return list;
  }

  @Override
  public int delete(Guestbook g) {
    int n = dao.delete(g);
    return n;
  }

  @Override
  public int update(Guestbook g) {
    int n = dao.update(g);
    return n;
  }

  @Override
  public Guestbook findOne(Guestbook g) {
    Guestbook guestbook = dao.findOne(g);
    return guestbook;
  }
}
