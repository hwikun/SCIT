package net.softsociety.spring3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.softsociety.spring3.dao.PersonDAO;
import net.softsociety.spring3.domain.Person;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  PersonDAO dao;

  @Override
  public int insertPerson(Person p) {
    int n = dao.insertPerson(p);
    return n;
  }

  @Override
  public int deletePerson(String idnum) {
    // TODO Auto-generated method stub
    return 0;
  }

}
