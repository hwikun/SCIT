package net.softsociety.spring2.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("ex")
@Controller
public class ExampleController {

  @GetMapping("calc1")
  public String calc1() {
    return "exView/calcForm";
  }

  @PostMapping("calc1")
  public String postCalc1(@RequestParam(name = "numA", defaultValue = "0") int num1,
      @RequestParam(name = "numB", defaultValue = "0") int num2, Model model) {
    int result = num1 + num2;
    model.addAttribute("result", result);

    return "exView/calcResult";
  }

  // 방문횟수 확인
  @GetMapping("cookie")
  public String cookie2(Model model, HttpServletResponse response,
      @CookieValue(name = "id", defaultValue = "") String id,
      @CookieValue(name = "count", defaultValue = "0") int count) {

    if (count == 0) {
      return "exView/cookieForm";
    } else {
      count++;

      Cookie idCookie = new Cookie("id", id);
      Cookie countCookie = new Cookie("count", Integer.toString(count));
      idCookie.setMaxAge(60 * 60 * 24 * 365);
      countCookie.setMaxAge(60 * 60 * 24 * 365);
      response.addCookie(idCookie);
      response.addCookie(countCookie);

      model.addAttribute("id", id);
      model.addAttribute("count", count);

      return "exView/cookieOutput";
    }
  }

  // 첫 방문시 아이디 받기
  @PostMapping("cookie")
  public String cookie2(HttpServletResponse response, String id) {
    if (id == null || id.isEmpty()) {
      return "exView/cookieForm";
    }
    Cookie idCookie = new Cookie("id", id);
    Cookie countCookie = new Cookie("count", "1");
    idCookie.setMaxAge(60 * 60 * 24 * 365);
    countCookie.setMaxAge(60 * 60 * 24 * 365);
    response.addCookie(idCookie);
    response.addCookie(countCookie);

    return "redirect:/";
  }
}
