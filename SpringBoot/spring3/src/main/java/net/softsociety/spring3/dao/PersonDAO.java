package net.softsociety.spring3.dao;

import org.apache.ibatis.annotations.Mapper;
import net.softsociety.spring3.domain.Person;

@Mapper
public interface PersonDAO {

  public int insertPerson(Person person);
}
