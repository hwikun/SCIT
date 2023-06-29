package net.softsociety.spring4.service;

import net.softsociety.spring4.domain.Member;

public interface MemberService {

  public boolean createMember(Member member);

  public boolean checkId(String searchid);

  public Member getMember(String memberid);

}
