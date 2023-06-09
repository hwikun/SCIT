package net.softsociety.spring2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// getter/setter/tostring. 생성자는 안만들어줌.
@AllArgsConstructor
// new Person(String name, int age, String phone);
@NoArgsConstructor
// new Person();
public class Person {
  String name;
  int age;
  String phone;
}
