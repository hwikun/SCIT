package net.softsociety.spring5.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring5.domain.Board;
import net.softsociety.spring5.domain.Reply;
import net.softsociety.spring5.service.BoardService;
import net.softsociety.spring5.util.PageNavigator;

@Controller
@Slf4j
@RequestMapping("admin")
public class AdminController {

  @Autowired
  BoardService boardService;

  // 게시판 목록의 페이지당 글 개수;
  @Value("${user.board.adminpage}")
  int countPerPage;

  // 게시판 목록의 페이지 이동 링크 개수;
  @Value("${user.board.group}")
  int pagePerGroup;


  @GetMapping("board/list")
  public String manageBoard(Model model, @RequestParam(name = "page", defaultValue = "1") int page,
      String type, String searchWord) {
    PageNavigator navi =
        boardService.getPageNavigator(pagePerGroup, countPerPage, page, type, searchWord);
    ArrayList<Board> list = boardService.getList(navi, type, searchWord);
    model.addAttribute("list", list);

    return "adminView/board";
  }

  @GetMapping("board/read")
  public String adminDetail(@RequestParam(name = "num", defaultValue = "0") int boardnum,
      Model model) {
    log.debug("boardnum: {}", boardnum);
    if (boardnum == 0) {
      return "redirect:/admin/board/list";
    }
    Board b = boardService.readBoard(boardnum);
    if (b == null) {
      return "redirect:/admin/board/list";
    }
    ArrayList<Reply> reply = boardService.readallReply(boardnum);
    if (reply == null)
      return "redirect:/board/list";
    model.addAttribute("board", b);
    model.addAttribute("replies", reply);

    return "boardView/detail";
  }

  @GetMapping("reply")
  public String manageReply() {
    return "adminView/reply";
  }

  @GetMapping("members")
  public String manageMembers() {
    return "adminView/members";
  }

}
