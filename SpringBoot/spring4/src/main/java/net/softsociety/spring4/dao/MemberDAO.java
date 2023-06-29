package net.softsociety.spring4.dao;

import org.apache.ibatis.annotations.Mapper;
import net.softsociety.spring4.domain.Member;

@Mapper
public interface MemberDAO {

  public int createMember(Member member);

  public Member getMember(String searchid);

}
