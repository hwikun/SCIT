package net.softsociety.spring4.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring4.domain.Guestbook;
import net.softsociety.spring4.service.GuestbookService;


@Controller
@Slf4j
@RequestMapping("guestbook")
public class GuestbookController {

  @Autowired
  private GuestbookService service;

  @GetMapping("insert")
  public String insert(@AuthenticationPrincipal UserDetails user, Model model) {
    model.addAttribute("loggedUser", user);
    return "inputForm";
  }

  @PostMapping("insert")
  public String insert(@AuthenticationPrincipal UserDetails user, Guestbook g) {
    log.debug("guestbook: {}", g);
    log.debug("username: {}", user.getUsername());
    log.debug("password: {}", user.getPassword());

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
