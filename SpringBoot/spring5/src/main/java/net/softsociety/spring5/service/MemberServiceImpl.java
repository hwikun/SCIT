package net.softsociety.spring5.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring5.dao.MemberDAO;
import net.softsociety.spring5.domain.Member;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

  @Autowired
  MemberDAO dao;

  @Autowired
  PasswordEncoder passwordEncoder;


  @Override
  public int signUp(Member m) {
    String pw = passwordEncoder.encode(m.getMemberpw());

    log.debug("암호화전: {}", m.getMemberpw());
    log.debug("암호화후: {}", pw);

    m.setMemberpw(pw);
    int n = dao.signUp(m);
    return n;
  }

  @Override
  public Member getMember(String memberid) {
    Member m = dao.getMember(memberid);
    return m;
  }

  @Override
  public boolean idCheck(String memberid) {
    return dao.getMember(memberid) == null;
  }

  @Override
  public boolean updateMember(Member member) {
    int result = dao.updateMember(member);
    return result != 0;
  }



}
