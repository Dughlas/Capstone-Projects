package com.techelevator.dao;

import com.techelevator.model.CommentDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class JdbcCommentDao implements CommentDao{
    private JdbcTemplate template;
    public JdbcCommentDao(JdbcTemplate template) {this.template = template;}


    @Override
    public void createNewComment(CommentDTO newComment) {
        int commentId = newComment.getCommentId();


    }

    @Override
    public List<CommentDTO> getAllCommentsByPhotoId(int photoId) {
        return null;

    }


}
