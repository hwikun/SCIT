package net.softsociety.spring3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import net.softsociety.spring3.domain.Person;
import net.softsociety.spring3.service.PersonService;

@Controller
public class PersonController {

  @Autowired
  PersonService service;

  @GetMapping("insert")
  public String insert() {
    Person p = new Person("990101-1111112", "김철수", 23);
    service.insertPerson(p);

    return "redirect:/";
  }
}
