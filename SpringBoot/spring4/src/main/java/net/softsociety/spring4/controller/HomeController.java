package net.softsociety.spring4.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import net.softsociety.spring4.domain.Guestbook;
import net.softsociety.spring4.service.GuestbookService;


@Controller
public class HomeController {

  @Autowired
  GuestbookService service;

  @GetMapping({"/", ""})
  public String home(Model model) {
    ArrayList<Guestbook> list = service.findAll();
    model.addAttribute("list", list);
    return "home";
  }

  @GetMapping("insert")
  public String insert() {
    return "inputForm";
  }

  @PostMapping("insert")
  public String insert1(Guestbook g) {
    int n = service.insert(g);
    return "redirect:/";
  }

  @PostMapping("delete")
  public String delete(Guestbook g) {
    int n = service.delete(g);
    return "redirect:/";
  }

  @GetMapping("list")
  public String list(Model model) {
    ArrayList<Guestbook> list = service.findAll();
    model.addAttribute("list", list);
    return "list2";
  }

  @PostMapping("gotoupdate")
  public String gotoupdate(Guestbook g, Model model) {
    Guestbook guestbook = service.findOne(g);
    if (guestbook != null) {
      model.addAttribute("item", guestbook);
      return "updateForm";
    } else {
      return "redirect:/list";
    }
  }

  @PostMapping("update")
  public String update(Guestbook g) {
    int n = service.update(g);
    return "redirect:/list";
  }
}
