package net.softsociety.spring4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import net.softsociety.spring4.dao.MemberDAO;
import net.softsociety.spring4.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private MemberDAO dao;

  @Override
  public boolean createMember(Member member) {
    String pw = passwordEncoder.encode(member.getMemberpw());
    member.setMemberpw(pw);
    int result = dao.createMember(member);
    return result != 0;
  }

  @Override
  public boolean checkId(String searchid) {
    return dao.getMember(searchid) == null;
  }

  @Override
  public Member getMember(String memberid) {

    return dao.getMember(memberid);
  }



}
