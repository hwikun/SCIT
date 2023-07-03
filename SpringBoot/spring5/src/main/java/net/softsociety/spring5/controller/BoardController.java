package net.softsociety.spring5.controller;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring5.domain.Board;
import net.softsociety.spring5.service.BoardService;

@Controller
@Slf4j
@RequestMapping("board")
public class BoardController {

  @Autowired
  BoardService service;

  @GetMapping("list")
  public String list(Model model) {
    ArrayList<Board> list = service.getList();
    model.addAttribute("list", list);

    return "boardView/list";

  }

  @GetMapping("write")
  public String write() {
    return "boardView/write";
  }

  @PostMapping("write")
  public String write(@AuthenticationPrincipal UserDetails user, Board b) {
    log.debug("input board: {}", b);
    log.debug("user: {}", user);

    b.setMemberid(user.getUsername());
    log.debug("post data: {}", b);

    boolean result = service.writeBoard(b);
    if (result == false)
      return "boardView/write";
    return "redirect:/board/list";
  }

  @GetMapping("read")
  public String detail(@RequestParam(name = "num", defaultValue = "0") int boardnum, Model model) {
    log.debug("boardnum: {}", boardnum);
    if (boardnum == 0) {
      return "redirect:/board/list";
    }
    Board b = service.readBoard(boardnum);
    if (b == null) {
      return "redirect:/board/list";
    }
    model.addAttribute("board", b);

    return "boardView/detail";
  }

  @GetMapping("delete")
  public String delete(@RequestParam(name = "boardnum", defaultValue = "0") int boardnum,
      @AuthenticationPrincipal UserDetails user) {
    HashMap<String, Object> map = new HashMap<>();
    map.put("user", user.getUsername());
    map.put("boardnum", boardnum);
    boolean result = service.deleteBoard(map);
    if (result == false)
      log.debug("삭제에 실패하였습니다");
    return "redirect:/board/list";
  }

  @GetMapping("update")
  public String update(@AuthenticationPrincipal UserDetails user,
      @RequestParam(name = "boardnum", defaultValue = "0") int boardnum, Model model) {
    Board b = service.getBoard(boardnum);
    if (user.getUsername().equals(b.getMemberid())) {
      model.addAttribute("oldData", b);
      return "boardView/updateForm";
    }
    return "redirect:/board/list";
  }

  @PostMapping("update")
  public String update(Board b) {
    boolean result = service.updateBoard(b);
    if (result == false)
      log.debug("수정에 실패했습니다");
    return "redirect:/board/list";
  }
}
