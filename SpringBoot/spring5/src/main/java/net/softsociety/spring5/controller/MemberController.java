package net.softsociety.spring5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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

  @GetMapping("loginForm")
  public String login() {
    return "memberView/loginForm";
  }

  // 수정form으로 이동
  @GetMapping("updateForm")
  public String updateForm(@AuthenticationPrincipal UserDetails user, Model model) {
    // 로그인한 아이디로 회원정보 검색
    Member me = service.getMember(user.getUsername());
    // 검색 결과를 Model에 저장
    model.addAttribute("user", me);
    // HTML로 포워딩
    log.debug("user: {}", user);
    return "memberView/updateForm";

  }

  // 수정 처리
  @PostMapping("update")
  public String update(@AuthenticationPrincipal UserDetails user, Member member) {
    // 로그인한 아이디를 member 객체에 추가
    member.setMemberid(user.getUsername());
    // Member 객체를 서비스로 전달하여 db 수정
    boolean result = service.updateMember(member);
    if (result == true)
      return "redirect:/";
    return "memberView/updateForm";
  }

}
