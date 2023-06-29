package net.softsociety.spring4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import net.softsociety.spring4.domain.Member;
import net.softsociety.spring4.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {

  @Autowired
  private MemberService service;

  @GetMapping("join")
  public String join() {
    return "memberView/join";
  }

  @PostMapping("join")
  public String join(Member member) {
    boolean result = service.createMember(member);
    if (result == false)
      return "memberView/join";
    return "redirect:/";
  }

  @GetMapping("checkid")
  public String checkid() {
    return "memberView/checkid";
  }

  @PostMapping("checkid")
  public String checkid(String searchid, Model model) {
    boolean result = service.checkId(searchid);
    model.addAttribute("searchid", searchid);
    model.addAttribute("result", result);
    return "memberView/checkid";
  }

  @GetMapping("loginForm")
  public String login() {
    return "memberView/loginForm";
  }
}
