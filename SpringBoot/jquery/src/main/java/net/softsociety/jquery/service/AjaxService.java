package net.softsociety.jquery.service;

import net.softsociety.jquery.domain.Member;
import net.softsociety.jquery.domain.Recommend;

public interface AjaxService {
    public Recommend getRecommend(int boardnum);

    public void updateCnt(int boardnum);

    public Boolean checkId(String id);

    public Boolean insertMember(Member member);
}
