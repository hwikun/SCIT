package net.softsociety.mysite.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  int userId;
  String username;
  String password;
  String email;
  String phone;
  String address;
  String createdAt;
}
