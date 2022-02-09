package com.techelevator.dao;

import com.techelevator.model.LikeDTO;
import com.techelevator.model.PostDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPostDao implements PostDao {
    private JdbcTemplate template;

    public JdbcPostDao(JdbcTemplate template) {
        this.template = template;
    }


    @Override
    public void createNewPost(PostDTO newPost) {
        int userId = newPost.getUserId();
        String photoUrl = newPost.getUrl();
        String caption = newPost.getCaption();


        try {
            String sql = "INSERT INTO photos(user_id, photo_url, caption) " +
                    " VALUES (?,?,?) ";
            int id = template.queryForObject(sql, Integer.class, userId, photoUrl, caption);

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

        while (result.next()) {
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
        String sql = "SELECT username, photo_id, photo_url, caption, profile_pic_url  " +
                "FROM photos p  " +
                "JOIN users u ON p.user_id = u.user_id  " +
                "join profile z on u.user_id = z.user_id " +
                "WHERE profile_pic_url IS NOT NULL " +
                "ORDER BY photo_id DESC";
        List<PostDTO> userPosts = new ArrayList<>();
        SqlRowSet result = template.queryForRowSet(sql);

        while (result.next()) {
            int photoId = result.getInt("photo_id");
            String photoUrl = result.getString("photo_url");
            String photoCaption = result.getString("caption");
            String username = result.getString("username");
            String profilePicUrl = result.getString("profile_pic_url");

            PostDTO postDTO = new PostDTO();
            postDTO.setPhotoId(photoId);
            postDTO.setUrl(photoUrl);
            postDTO.setUsername(username);
            postDTO.setCaption(photoCaption);
            postDTO.setProfilePicUrl(profilePicUrl);

            userPosts.add(postDTO);
        }
        return userPosts;
    }


    @Override
    public void newLike(LikeDTO newLike) {
        String sql = "INSERT INTO liked_photos (user_id, photo_id, is_liked)" +
                "VALUES (?,?,?)";
        int userId = newLike.getUserId();
        int photoId = newLike.getPhotoId();


        template.update(sql, userId, photoId, true);
    }

    @Override
    public int numberOfLikes(int photoId) {
        String sql = "SELECT COUNT(*) like_id FROM liked_photos WHERE photo_id = ?";
        int count = template.queryForObject(sql, Integer.class, photoId);
        return count;
    }

    @Override
    public void deleteLike(LikeDTO deleteLike) {
        String sql = "Delete FROM liked_photos WHERE " +
                "user_id = ? AND photo_id = ?;";

        int userId = deleteLike.getUserId();
        int photoId = deleteLike.getPhotoId();

        template.update(sql, userId, photoId);
    }

    @Override
    public boolean isItLiked(LikeDTO likeObject) {
        String sql = "Select is_liked from liked_photos " +
                "WHERE user_id = ? AND photo_id = ? ";
        int userId = likeObject.getUserId();
        int photoId = likeObject.getPhotoId();

        boolean isLiked = false;
        try {
            if (template.queryForObject(sql, Boolean.class, userId, photoId) == true) {
                isLiked = true;
                return isLiked;
            }
        } catch (Exception e) {
            return isLiked;
        }
        return false;
    }
}