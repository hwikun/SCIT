package net.softsociety.spring5.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.softsociety.spring5.dao.MemberDAO;
import net.softsociety.spring5.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {

  @Autowired
  MemberDAO dao;

  @Override
  public int signUp(Member m) {
    int n = dao.signUp(m);
    return n;
  }

}