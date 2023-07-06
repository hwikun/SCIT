package net.softsociety.spring5.controller;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring5.domain.Board;
import net.softsociety.spring5.service.BoardService;
import net.softsociety.spring5.util.FileService;
import net.softsociety.spring5.util.PageNavigator;

@Controller
@Slf4j
@RequestMapping("board")
public class BoardController {

  @Autowired
  private BoardService service;

  @Value("${spring.servlet.multipart.location}")
  String uploadPath;

  // 게시판 목록의 페이지당 글 개수;
  @Value("${user.board.page}")
  int countPerPage;

  // 게시판 목록의 페이지 이동 링크 개수;
  @Value("${user.board.group}")
  int pagePerGroup;

  @GetMapping("list")
  public String list(Model model, String type, String searchWord,
      @RequestParam(name = "page", defaultValue = "1") int page) {
    log.debug("검색대상: {}, 검색어: {}", type, searchWord);

    PageNavigator navi =
        service.getPageNavigator(pagePerGroup, countPerPage, page, type, searchWord);



    ArrayList<Board> list = service.getList(navi, type, searchWord);
    model.addAttribute("list", list);

    return "boardView/list";

  }

  @GetMapping("write")
  public String write() {
    return "boardView/write";
  }

  @PostMapping("write")
  public String write(@AuthenticationPrincipal UserDetails user, Board b, MultipartFile upload) {

    b.setMemberid(user.getUsername());

    if (upload != null && !upload.isEmpty()) {
      log.debug("file contenttype: {}", upload.getContentType());
      log.debug("file originalname: {}", upload.getOriginalFilename());
      log.debug("file size: {}", upload.getSize());
      String savedfile = FileService.saveFile(upload, uploadPath);
      b.setOriginalfile(upload.getOriginalFilename());
      b.setSavedfile(savedfile);
    }

    log.debug("input board: {}", b);
    log.debug("user: {}", user);

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
  public String update(Board b, MultipartFile upload) {
    if (upload != null && !upload.isEmpty()) {
      if (service.getBoard(b.getBoardnum()).getOriginalfile() != null) {
        FileService.deleteFile(uploadPath + "/" + b.getSavedfile());
      }
      String savedfile = FileService.saveFile(upload, uploadPath);
      b.setOriginalfile(upload.getOriginalFilename());
      b.setSavedfile(savedfile);
    }
    boolean result = service.updateBoard(b);
    if (result == false)
      log.debug("수정에 실패했습니다");
    return "redirect:/board/list";
  }

  @GetMapping("download")
  public void download(@RequestParam(name = "boardnum", defaultValue = "0") int boardnum,
      HttpServletRequest req, HttpServletResponse res) {
    // 해당 글의 첨부파일이름 확인
    Board b = service.getBoard(boardnum);
    String fullPath = uploadPath + "/" + b.getSavedfile(); // 실제 저장된 이름으로 불러오기!

    // 파일의 경로를 이용해서 FileInputStream 객체를 생성;

    // res를 통해 파일 전송
    try {
      res.setHeader("Content-Disposition",
          " attachment;filename=" + URLEncoder.encode(b.getOriginalfile(), "UTF-8"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    try {
      FileInputStream in = new FileInputStream(fullPath);
      ServletOutputStream out = res.getOutputStream();
      FileCopyUtils.copy(in, out);
      in.close();
      out.close();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
