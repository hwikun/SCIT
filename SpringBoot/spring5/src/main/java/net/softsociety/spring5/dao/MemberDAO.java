package net.softsociety.spring5.dao;

import org.apache.ibatis.annotations.Mapper;
import net.softsociety.spring5.domain.Member;

@Mapper
public interface MemberDAO {

  public int signUp(Member m);

  public Member getMember(String memberid);

  public int updateMember(Member member);

}
