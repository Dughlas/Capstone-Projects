package com.techelevator.controller;

import com.techelevator.dao.PostDao;
import com.techelevator.model.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServerController {

    @Autowired
    PostDao postDao;

    @RequestMapping(path="/addPost", method = RequestMethod.POST)
    public void createPost(@RequestBody PostDTO newPost) {
        postDao.createNewPost(newPost);
    }

    @RequestMapping(path="/viewPosts/user/{id}", method = RequestMethod.GET)
    public List<PostDTO> viewUserPosts(@PathVariable("id") int userId) {
        return postDao.getAllPostsByUser(userId);
    }

}
