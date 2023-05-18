package board.dao;

import board.vo.Member;

public interface MemberMapper {

	public int insertMember(Member m);

	public Member selectMember(String id);

}
