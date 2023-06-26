package net.softsociety.spring5.service;

import net.softsociety.spring5.domain.Member;

public interface MemberService {

  public int signUp(Member m);

  public Member getMember(String memberid);

  public boolean idCheck(String memberid);

}
