package net.softsociety.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring2.domain.Person;

@Slf4j
@Controller
public class ParamController {

  @GetMapping("param/input1")
  public String input1() {

    return "paramView/view1";
  }

  @PostMapping("param/input1")
  public String save1(String name, int age, String phone) { // age는 자동 형변환
    log.debug("name={} age={} phone={}", name, age, phone);

    return "redirect:/";
  }

  @GetMapping("param/input2")
  public String input2() {

    return "paramView/view2";
  }

  @PostMapping("param/input2")
  public String save2(Person p) {
    log.debug("전달된 값:{}", p);
    return "redirect:/";
  }

  @GetMapping("param/input3")
  public String save3(@RequestParam(name = "name", defaultValue = "기본값") String name,
      @RequestParam(name = "age", defaultValue = "0") int age) {
    log.debug("{}, {}", name, age);
    return "redirect:/";
  }

  @GetMapping("param/model")
  public String model(Model m) { // model 클래스. springboot가 준비해줌
    String s = "abcd";
    int n = 1000;
    Person p = new Person("홍길동", 10, "01011112222");

    m.addAttribute("string", s);
    m.addAttribute("int", n);
    m.addAttribute("person", p);

    return "paramView/model";
  }
}
