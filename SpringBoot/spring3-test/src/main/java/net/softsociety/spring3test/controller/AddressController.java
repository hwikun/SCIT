package net.softsociety.spring3test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import net.softsociety.spring3test.model.Address;
import net.softsociety.spring3test.service.AddressService;

@Controller
public class AddressController {

  @Autowired
  AddressService service;


  @GetMapping("create")
  public String create(Address address) {
    Address a = new Address("나휘선", "서울시 동대문구", "02498", "010-1111-1111");
    service.createAddress(a);

    return "redirect:/";
  }
}
