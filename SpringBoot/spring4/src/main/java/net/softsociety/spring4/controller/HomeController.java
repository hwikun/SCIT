package net.softsociety.spring4.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import net.softsociety.spring4.domain.Guestbook;
import net.softsociety.spring4.service.GuestbookService;

@Controller
public class HomeController {

  @Autowired
  private GuestbookService service;

  @GetMapping({"/", ""})
  public String home(Model model) {
    ArrayList<Guestbook> list = service.findAll();
    model.addAttribute("list", list);
    return "home";
  }
}
