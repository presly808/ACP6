package ua.artcode.dao;

import ua.artcode.model.UserPost;

import java.util.List;

/**
 * Created by serhii on 07.06.15.
 */
public interface PostDao extends CrudDao<UserPost> {


    UserPost create(UserPost user);

    UserPost findById(long id);

    void delete(long id);

    void update(UserPost user);

    List<UserPost> findAll();

    List<UserPost> userPosts(long id);

    List<UserPost> findByKey(String keyWord);
}
