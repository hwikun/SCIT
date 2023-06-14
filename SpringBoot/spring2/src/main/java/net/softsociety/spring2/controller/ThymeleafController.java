package net.softsociety.spring2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring2.domain.Person;

@Slf4j
@RequestMapping("th")
@Controller
public class ThymeleafController {

  @GetMapping("thymeleaf1")
  public String thymeleaf1(Model model) {
    String str = "문자열";
    int num = 100;
    Person p = new Person("홍길동", 22, "010-1111-1111");
    String tag = "<marquee>HTML 태그</marquee>";
    String url = "https://google.com";

    model.addAttribute("str", str);
    model.addAttribute("num", num);
    model.addAttribute("tag", tag);
    model.addAttribute("person", p);

    return "thView/thymeleaf1";
  }

  @GetMapping("thymeleaf2")
  public String thymeleaf2(Model m) {
    ArrayList<String> slist = new ArrayList<>();
    slist.add("aaa");
    slist.add("bbb");
    slist.add("ccc");
    slist.add("ddd");

    HashMap<String, Object> map = new HashMap<>();
    map.put("name", "키보드");
    map.put("price", 10000);

    m.addAttribute("slist", slist);
    m.addAttribute("map", map);


    return "thView/thymeleaf2";
  }
}
