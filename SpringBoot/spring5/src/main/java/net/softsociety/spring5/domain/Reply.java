package net.softsociety.spring5.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
  int replynum;
  int boardnum;
  String memberid;
  String replytext;
  String createdat;
}
