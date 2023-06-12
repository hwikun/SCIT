package net.softsociety.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

  @GetMapping("ex/calc1")
  public String calc1() {
    return "calcView/view";
  }

  @PostMapping("ex/calc1")
  public String postCalc1(@RequestParam(name = "numA", defaultValue = "0") int num1,
      @RequestParam(name = "numB", defaultValue = "0") int num2, Model model) {
    int result = num1 + num2;
    model.addAttribute("result", result);

    return "calcView/result";
  }

}
