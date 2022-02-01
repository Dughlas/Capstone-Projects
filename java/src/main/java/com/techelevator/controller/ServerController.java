package com.techelevator.controller;

import com.techelevator.dao.PostDao;
import com.techelevator.model.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    @Autowired
    PostDao postDao;

    @RequestMapping(path="/addPost", method = RequestMethod.POST)
    public void createPost(@RequestBody PostDTO newPost) {
        postDao.createNewPost(newPost);
    }

}
