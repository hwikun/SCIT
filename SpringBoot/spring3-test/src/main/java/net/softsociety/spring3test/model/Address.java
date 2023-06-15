package net.softsociety.spring3test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
  String name;
  String address;
  String zipcode;
  String phone;

}
