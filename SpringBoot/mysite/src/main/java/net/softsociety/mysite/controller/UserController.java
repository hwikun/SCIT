package net.softsociety.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.mysite.domain.User;
import net.softsociety.mysite.service.UserService;

@Controller
@RequestMapping("users")
@Slf4j
public class UserController {
  @Autowired
  UserService service;

  @GetMapping("signup")
  public String signup() {
    return "usersView/signupForm";
  }

  @PostMapping("signup")
  public String signup(User user) {
    int n = service.createUser(user);
    if (n != 0)
      return "redirect:/";
    else
      return "redirect:/users/signup";
  }

  @GetMapping("checkid")
  public String checkid() {
    return "usersView/checkid";
  }

  @PostMapping("checkid")
  public String checkid(String searchid, Model model) {
    boolean result = service.idCheck(searchid);
    model.addAttribute("searchid", searchid);
    model.addAttribute("result", result);
    return "usersView/checkid";
  }

  @GetMapping("inputaddress")
  public String inputAddress() {
    return "usersView/inputaddress";
  }

  @PostMapping("inputaddress")
  public String inputAddress(Model model) {
    return "usersView/signup";
  }

}
