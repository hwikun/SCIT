package net.softsociety.spring2.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("ss")
@Controller
public class SessionController {

  @GetMapping("session1")
  public String session1(HttpSession session) {
    session.setAttribute("test", "세션에 저장한 문자열");
    return "redirect:/";
  }

  @GetMapping("session2")
  public String session2(HttpSession session) {
    String s = (String) session.getAttribute("test"); // 타입캐스팅 필수
    log.debug("세션의 값:{}", s);

    return "redirect:/";
  }

  @GetMapping("session3")
  public String session3(HttpSession session) {
    session.removeAttribute("test");
    return "redirect:/";
  }

  @GetMapping("login")
  public String login() {
    return "loginForm";
  }

  @PostMapping("auth")
  public String login(String id, String pw, HttpSession session) {
    String dbid = "abc";
    String dbpw = "123";
    if (id != null && pw != null && id.equals(dbid) && pw.equals(dbpw)) {
      session.setAttribute("loginID", id);
      return "redirect:/";
    } else
      return "loginForm";
  }

  @GetMapping("logout")
  public String logout(HttpSession session) {
    session.removeAttribute("loginID");
    return "redirect:/";
  }

}
