package net.softsociety.spring5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring5.domain.Member;
import net.softsociety.spring5.service.MemberService;

@Controller
@RequestMapping("member")
@Slf4j
public class MemberController {

  @Autowired
  MemberService service;

  @GetMapping("join")
  public String join() {
    return "memberView/join";
  }

  @PostMapping("join")
  public String join(Member m) {
    log.debug("회원가입 정보: {}", m);
    int n = service.signUp(m);
    if (n != 0) {
      return "redirect:/";
    }
    return "redirect:/member/join";
  }

  @GetMapping("checkid")
  public String checkid() {
    return "memberView/checkid";
  }

  @PostMapping("checkid")
  public String checkId(String searchid, Model model) {
    log.debug("memberId: {}", searchid);
    boolean result = service.idCheck(searchid);
    model.addAttribute("searchid", searchid);
    model.addAttribute("result", result);
    return "memberView/checkid";
  }
}
