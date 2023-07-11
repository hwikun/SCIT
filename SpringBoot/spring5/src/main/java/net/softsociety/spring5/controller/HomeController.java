package net.softsociety.spring5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping({"/", ""})
  public String home() {
    return "home";
  }

  @GetMapping("thymeleaf")
  public String thymeleaf() {
    return "thymeleaf";
  }

  @GetMapping("admin")
  public String admin() {
    return "admin";
  }

  @GetMapping("error")
  public String error() {
    return "error";
  }
}
