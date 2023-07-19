package net.softsociety.jquery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

  String name;
  int age;
  String phone;

  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + ", phone=" + phone + "]";
  }



}
