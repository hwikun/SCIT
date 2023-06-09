package net.softsociety.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring2.domain.Person;

@Slf4j
@Controller
public class LombokController {

  @GetMapping("lom/lombok")
  public String lombokTest() {
    System.out.println("lombokTest() 실행");
    Person p = new Person();
    p.setName("김");
    return "redirect:/"; // 다시 보내줄때 localhost:8888/spring2/ 으로 보낸다.
  }

  @GetMapping("lom/logger")
  public String logTest() {
    log.debug("debug로 출력"); // 개발용
    log.info("info로 출력"); // 상용 이상
    log.warn("warn 출력");
    log.error("error로 출력");

    int a = 100;
    String b = "aaaaa";
    Person c = new Person();

    log.debug("a={} b={} c={}", a, b, c);

    return "redirect:/";
  }
}
