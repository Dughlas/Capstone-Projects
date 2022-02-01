package com.techelevator.dao;

import com.techelevator.model.PostDTO;

import java.util.List;

public interface PostDao {

    void createNewPost(PostDTO newPost);

    List<PostDTO> getAllPostsByUser(int userId);


}