package ua.artcode.service;

import ua.artcode.model.UserPost;

import java.util.List;

/**
 * Created by serhii on 30.05.15.
 */
public interface PostService {

    UserPost createPost(long userId, String title, String text);
    List<UserPost> userPosts(long userId);
    UserPost getById(long postId);
    boolean delete(long userId, long postId);


}
