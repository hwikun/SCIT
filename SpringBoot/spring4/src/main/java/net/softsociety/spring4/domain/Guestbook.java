package net.softsociety.spring4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guestbook {
  int num;
  String name;
  String password;
  String message;
  String inputdate;
}
