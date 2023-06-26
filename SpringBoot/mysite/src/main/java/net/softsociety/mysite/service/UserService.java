package net.softsociety.mysite.service;

import net.softsociety.mysite.domain.User;

public interface UserService {

  int createUser(User user);

  boolean idCheck(String searchid);

}
