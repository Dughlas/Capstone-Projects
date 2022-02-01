package com.techelevator.dao;

import com.techelevator.model.PostDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcPostDao implements PostDao{
    private JdbcTemplate template;

    public JdbcPostDao(JdbcTemplate template) {this.template = template;}


    @Override
    public void createNewPost(PostDTO newPost) {
        int userId = newPost.getUserId();
        String photoUrl = newPost.getUrl();
        String  caption = newPost.getCaption();

        try{
            String sql = "INSERT INTO photos(user_id, photo_url, caption) " +
                    " VALUES (?,?,?) ";
            int id = template.queryForObject(sql, Integer.class,userId,photoUrl,caption);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
