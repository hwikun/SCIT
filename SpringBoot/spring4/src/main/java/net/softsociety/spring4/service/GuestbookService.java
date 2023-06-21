package net.softsociety.spring4.service;

import java.util.ArrayList;
import net.softsociety.spring4.domain.Guestbook;

public interface GuestbookService {

  public int insert(Guestbook g);

  ArrayList<Guestbook> findAll();

  public int delete(Guestbook g);

  public int update(Guestbook g);

  public Guestbook findOne(Guestbook g);
}
