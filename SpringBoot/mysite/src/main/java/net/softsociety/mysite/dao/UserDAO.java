package net.softsociety.mysite.dao;

import org.apache.ibatis.annotations.Mapper;
import net.softsociety.mysite.domain.User;

@Mapper
public interface UserDAO {

  public int createUser(User user);

  public User getUser(String searchid);

}
