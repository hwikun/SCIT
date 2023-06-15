package net.softsociety.spring3test.dao;

import org.apache.ibatis.annotations.Mapper;
import net.softsociety.spring3test.model.Address;

@Mapper
public interface AddressDAO {

  public int createAddress(Address a);
}
