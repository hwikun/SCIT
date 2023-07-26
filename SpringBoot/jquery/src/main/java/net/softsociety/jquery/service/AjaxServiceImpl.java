package net.softsociety.jquery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.jquery.dao.AjaxDAO;
import net.softsociety.jquery.domain.Member;
import net.softsociety.jquery.domain.Recommend;

@Service
@Slf4j
public class AjaxServiceImpl implements AjaxService {

    @Autowired
    AjaxDAO dao;

    @Override
    public Recommend getRecommend(int boardnum) {
        Recommend recommend = dao.getRecommend(boardnum);
        return recommend;
    }

    @Override
    public void updateCnt(int boardnum) {
        dao.updateCnt(boardnum);
    }

    @Override
    public Boolean checkId(String id) {
        int n = dao.checkId(id);
        log.debug("n: {}",n);
        return n == 0 ? true : false;
    }

    @Override
    public Boolean insertMember(Member member) {
        return dao.insertMember(member) != 0 ? true : false;
    }
    
}
