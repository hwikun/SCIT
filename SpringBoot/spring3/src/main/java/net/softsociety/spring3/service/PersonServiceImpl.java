package net.softsociety.spring3.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring3.dao.PersonDAO;
import net.softsociety.spring3.domain.Person;

@Slf4j
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
    int n = dao.deletePerson(idnum);
    return 0;
  }

  @Override
  public int deletesByName(String name) {
    int n = dao.deletesByName(name);
    return n;
  }

  @Override
  public int updatePerson(Person p) {
    int n = dao.updatePerson(p);
    return n;
  }

  @Override
  public Person selectOne(String idnum) {
    Person p = dao.selectOne(idnum);
    return p;
  }

  @Override
  public ArrayList<Person> selectAll() {
    ArrayList<Person> list = dao.selectAll();
    return list;
  }



}
