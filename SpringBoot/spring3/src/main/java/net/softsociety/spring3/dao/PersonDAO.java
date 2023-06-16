package net.softsociety.spring3.dao;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;
import net.softsociety.spring3.domain.Person;

@Mapper
public interface PersonDAO {

  public int insertPerson(Person person);

  public int deletePerson(String idnum);

  public int deletesByName(String name);

  public int updatePerson(Person p);

  public Person selectOne(String idnum);

  public ArrayList<Person> selectAll();
}
