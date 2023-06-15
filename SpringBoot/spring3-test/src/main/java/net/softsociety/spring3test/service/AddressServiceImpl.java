package net.softsociety.spring3test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.softsociety.spring3test.dao.AddressDAO;
import net.softsociety.spring3test.model.Address;

@Service
public class AddressServiceImpl implements AddressService {

  @Autowired
  AddressDAO dao;

  @Override
  public int createAddress(Address a) {
    int n = dao.createAddress(a);

    return n;
  }

}
