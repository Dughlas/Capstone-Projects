package com.techelevator.controller;

import com.techelevator.dao.PostDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class ServerController {

    @Autowired
    PostDao postDao;
    @Autowired
    UserDao userDao;

    @RequestMapping(path="/addPost", method = RequestMethod.POST)
    public void createPost(@RequestBody PostDTO newPost) {
        int id = userDao.findIdByUsername(newPost.getUsername());
        String caption = newPost.getCaption();
        String url = newPost.getUrl();

        PostDTO postablePost = new PostDTO();
        postablePost.setCaption(caption);
        postablePost.setUrl(url);
        postablePost.setUserId(id);

        postDao.createNewPost(postablePost);
    }

    @RequestMapping(path="/viewPosts/user/{id}", method = RequestMethod.GET)
    public List<PostDTO> viewUserPosts(@PathVariable("id") int userId) {
        return postDao.getAllPostsByUser(userId);
    }

    @RequestMapping(path="/homeFeed", method = RequestMethod.GET)
    public List<PostDTO> HomeFeed() {
        return postDao.photoFeed();
    }

}
