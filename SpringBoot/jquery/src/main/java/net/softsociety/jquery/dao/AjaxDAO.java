package net.softsociety.jquery.dao;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.jquery.domain.Member;
import net.softsociety.jquery.domain.Recommend;

@Mapper
public interface AjaxDAO {

    public Recommend getRecommend(int boardnum);

    public int updateCnt(int boardnum);

    public int checkId(String id);

    public int insertMember(Member member);

}
