package net.softsociety.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.softsociety.mysite.dao.UserDAO;
import net.softsociety.mysite.domain.User;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserDAO dao;

  @Override
  public int createUser(User user) {
    int n = dao.createUser(user);
    return n;
  }

  @Override
  public boolean idCheck(String searchid) {
    // TODO Auto-generated method stub
    return dao.getUser(searchid) == null;
  }

}
