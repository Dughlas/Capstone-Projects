package com.techelevator.dao;

import com.techelevator.model.ProfileDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcProfileDAO  implements ProfileDAO{
    private JdbcTemplate template;

    public JdbcProfileDAO(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void addProfileInfo(ProfileDTO profileDTO) {
        String sql = "INSERT INTO profile(user_id, bio, profile_pic_url) " +
                "VALUES (?,?,?)";
        int userId = profileDTO.getUserId();
        String bio = profileDTO.getBio();
        String profilePicUrl = profileDTO.getProfilePicUrl();

        try{
            int id = template.queryForObject(sql,Integer.class,userId,bio, profilePicUrl);
        }catch (Exception e) {}
    }
}
