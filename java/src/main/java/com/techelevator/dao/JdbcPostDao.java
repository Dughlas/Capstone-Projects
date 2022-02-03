package com.techelevator.dao;

import com.techelevator.model.PostDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<PostDTO> getAllPostsByUser(int userId) {
        String sql = "SELECT photo_id, photo_url, caption " +
                " FROM photos " +
                " WHERE user_id = ?";
        List<PostDTO> userPosts = new ArrayList<>();
        SqlRowSet result = template.queryForRowSet(sql, userId);

        while(result.next()) {
            int photoId = result.getInt("photo_id");
            String photoUrl = result.getString("photo_url");
            String photoCaption = result.getString("caption");

            PostDTO postDTO = new PostDTO();
            postDTO.setPhotoId(photoId);
            postDTO.setUrl(photoUrl);
            postDTO.setCaption(photoCaption);
            userPosts.add(postDTO);
        }
        return userPosts;
    }

    @Override
    public List<PostDTO> photoFeed() {
        String sql = "SELECT username, photo_id, photo_url, caption " +
                "FROM photos p " +
                "JOIN users u ON p.user_id = u.user_id  " +
                "ORDER BY photo_id DESC";
        List<PostDTO> userPosts = new ArrayList<>();
        SqlRowSet result = template.queryForRowSet(sql);

        while(result.next()) {
            int photoId = result.getInt("photo_id");
            String photoUrl = result.getString("photo_url");
            String photoCaption = result.getString("caption");
            String username = result.getString("username");

            PostDTO postDTO = new PostDTO();
            postDTO.setPhotoId(photoId);
            postDTO.setUrl(photoUrl);
            postDTO.setUsername(username);
            postDTO.setCaption(photoCaption);
            userPosts.add(postDTO);
        }
        return userPosts;
    }

    @Override
    public List<PostDTO> favoriteFeed() {
        String sql = "Select f.photo_id, photo_url, p.user_id, caption from favorites f " +
                " join photos p on f.photo_id = p.photo_id;";
        List<PostDTO> userPosts = new ArrayList<>();
        SqlRowSet result = template.queryForRowSet(sql);

        while(result.next()) {
            int photoId = result.getInt("photo_id");
            String photoUrl = result.getString("photo_url");
            String photoCaption = result.getString("caption");

            PostDTO postDTO = new PostDTO();
            postDTO.setPhotoId(photoId);
            postDTO.setUrl(photoUrl);
            postDTO.setCaption(photoCaption);
            userPosts.add(postDTO);
        }
        return userPosts;
    }
}
