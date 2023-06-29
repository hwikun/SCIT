package net.softsociety.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import net.softsociety.mysite.dao.UserDAO;
import net.softsociety.mysite.domain.User;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDAO dao;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public int createUser(User user) {
    String pw = passwordEncoder.encode(user.getPassword());

    user.setPassword(pw);
    int n = dao.createUser(user);
    return n;
  }

  @Override
  public boolean idCheck(String searchid) {
    return dao.getUser(searchid) == null;
  }

  @Override
  public boolean updateUser(User user) {

    return dao.updateUser(user) != 0;
  }



}
