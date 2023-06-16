package net.softsociety.spring3.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring3.domain.Person;
import net.softsociety.spring3.service.PersonService;

@Slf4j
@Controller
public class PersonController {

  @Autowired
  PersonService service;

  @GetMapping("insert")
  public String insert() {

    return "insertForm";
  }

  @PostMapping("insert")
  public String insert(Person p) {
    service.insertPerson(p);

    return "redirect:/";
  }

  // 삭제
  @GetMapping("delete")
  public String delete() {

    return "deleteForm";
  }

  @PostMapping("delete")
  public String delete(String idnum, Model model) {
    int n = service.deletePerson(idnum);
    if (n == 0) {
      log.debug("삭제 실패");
      model.addAttribute("error", "삭제 실패");
      return "deleteForm";
    }
    return "redirect:/";
  }

  @GetMapping("delete2")
  public String delete2() {

    return "delete2Form";
  }

  @PostMapping("delete2")
  public String delete2(String name, Model model) {
    int n = service.deletesByName(name);
    log.debug("삭제된 행:", n);
    if (name.length() < 2) {
      log.debug("검색할 단어가 너무 짧습니다.");
      model.addAttribute("error", "검색할 단어가 너무 짧습니다.");
      return "delete2Form";
    }
    if (n == 0) {
      log.debug("삭제 실패");
      model.addAttribute("error", "삭제 실패");
      return "delete2Form";
    }
    return "redirect:/";
  }

  @GetMapping("update")
  public String update() {

    return "updateForm";
  }

  @PostMapping("update")
  public String update(Person p) {
    service.updatePerson(p);
    return "redirect:/";
  }

  @GetMapping("selectOne")
  public String selectOne(String idnum, Model model) {
    log.debug(idnum);
    Person p = service.selectOne(idnum);
    log.debug("조회결과: {}", p);
    model.addAttribute("person", p);
    return "selectOne";
  }

  @GetMapping("selectAll")
  public String selectAll(Model model) {
    ArrayList<Person> list = service.selectAll();
    model.addAttribute("list", list);

    return "selectAll";
  }
}
