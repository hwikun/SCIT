package net.softsociety.jquery.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.jquery.dao.CommentDAO;
import net.softsociety.jquery.domain.Comment;

@Slf4j
@RequestMapping("aj")
@Controller
public class CommentRestController {

    @Autowired
    CommentDAO dao;

    @GetMapping("comment")
    public String comment() {
        return "ajaxView/comment";
    }

    @ResponseBody
    @PostMapping("insert")
    public void insert(Comment comment) {
        log.debug("comment: {}", comment);
        int n = dao.insertComment(comment);
    }

    @ResponseBody
    @GetMapping("getComments")
    public ArrayList<Comment> getComments() {
        ArrayList<Comment> list = dao.getComments();
        log.debug("list: {}", list);
        return list;
    }

    @ResponseBody
    @PostMapping("deleteComment")
    public void deleteComment(int num) {
        log.debug("num: {}", num);
        int n = dao.deleteComment(num);
    }
}
