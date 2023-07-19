package net.softsociety.jquery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.jquery.domain.Person;

@Controller
@Slf4j
@RequestMapping("aj")
public class AjaxController {

  @GetMapping("aj1")
  public String aj1() {
    return "ajaxView/aj1";
  };

  // Ajax. 실제 데이터로 반환 처리
  @ResponseBody
  @GetMapping("test1")
  public void test1() {
    log.debug("test1 실행");
  };

  @ResponseBody
  @PostMapping("test2")
  public void test2(@RequestParam(name = "str", defaultValue = "문자열이 없습니다") String str) {
    log.debug("test2 실행");
    log.debug("str: {}", str);
  };

  @ResponseBody
  @GetMapping("test3")
  public String test3() {
    log.debug("test3 실행");
    return "서버 문자열입니다:)Ajax최고!!!";
  };

  @ResponseBody
  @PostMapping("test4")
  public String test4(@RequestParam(name = "str", defaultValue = "aaa") String str) {
    log.debug("test4 실행");
    String result = str.toUpperCase();
    log.debug(result);
    return result;
  };

  @GetMapping("aj2")
  public String aj2() {
    return "ajaxView/aj2";
  }

  @ResponseBody
  @PostMapping("insert1")
  public void insert1(String name, int age, String phone) {
    log.debug("name: {}, age: {}, phone: {}", name, age, phone);
  }

  @ResponseBody
  @PostMapping("insert2")
  public void insert2(Person p) {
    log.debug("person: {}", p);
  }

}
