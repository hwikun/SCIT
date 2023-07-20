package net.softsociety.jquery.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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

  @ResponseBody
  @PostMapping("insert3")
  public void insert3(Person p) {
    log.debug("전달된값 : {}", p);
  }

  @ResponseBody
  @GetMapping("getObj")
  public Person getObj() {
    Person p = new Person("홍길동", 22, "010-2222-2222");
    return p;
  }

  @ResponseBody
  @GetMapping("getList")
  public ArrayList<Person> getList() {
    ArrayList<Person> list = new ArrayList<>();
    list.add(new Person("홍길동", 22, "010-2222-3333"));
    list.add(new Person("홍길순", 23, "010-2222-4444"));
    list.add(new Person("홍길자", 24, "010-2222-5555"));
    return list;
  }

  @ResponseBody
  @PostMapping("sendArr1")
  public void sendArr1(String []arr) {
    if(arr == null) log.debug("arr: null");
    else {
      for (String s : arr) {
        log.debug("arr: {}", s);
      }
    }
  }

  @ResponseBody
  @PostMapping("sendArr2")
  public void sendArr1(String arr) throws Exception {
    if (arr == null) {
      log.debug("arr: null");
      return;
    }
    ObjectMapper objectMapper = new ObjectMapper();
    ArrayList<Person> list = objectMapper.readValue(arr, new TypeReference<ArrayList<Person>>() {});
    
    log.debug("object: {}",list);

    for(Object obj : list) {
      log.debug("타입: {}",obj.getClass());
      log.debug("값: {}", obj);
    }
  }
}
