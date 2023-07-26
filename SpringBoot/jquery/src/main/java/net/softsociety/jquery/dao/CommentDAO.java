package net.softsociety.jquery.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.jquery.domain.Comment;

@Mapper
public interface CommentDAO {

    int insertComment(Comment comment);

    ArrayList<Comment> getComments();

    int deleteComment(int num);

}
