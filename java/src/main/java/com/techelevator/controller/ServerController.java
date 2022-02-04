package com.techelevator.controller;

import com.techelevator.dao.CommentDao;
import com.techelevator.dao.PostDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.CommentDTO;
import com.techelevator.model.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class ServerController {

    @Autowired
    PostDao postDao;
    @Autowired
    UserDao userDao;
    @Autowired
    CommentDao commentDao;

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

    @RequestMapping(path="/viewPosts/{username}", method = RequestMethod.GET)
    public List<PostDTO> viewUserPosts(@PathVariable("username") String username) {
        int id = userDao.findIdByUsername(username);
        return postDao.getAllPostsByUser(id);
    }

    @RequestMapping(path="/homeFeed", method = RequestMethod.GET)
    public List<PostDTO> HomeFeed() {
        return postDao.photoFeed();
    }

    @RequestMapping(path="/viewComments/{photoId}", method = RequestMethod.GET)
    public List<CommentDTO> viewPostComments(@PathVariable("photoId") int photoId){
        return commentDao.getAllCommentsByPhotoId(photoId);
    }
}
