package net.softsociety.spring4.dao;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;
import net.softsociety.spring4.domain.Guestbook;

@Mapper
public interface GuestbookDAO {
  public int insert(Guestbook g);

  public ArrayList<Guestbook> findAll();

  public int delete(Guestbook g);
}
