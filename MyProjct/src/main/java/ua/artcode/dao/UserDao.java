package ua.artcode.dao;

import ua.artcode.model.User;

import java.util.List;

/**
 * Created by serhii on 30.05.15.
 */
public interface UserDao {

    User create(User user);

    User findByEmail(String email);

    User findById(long id);

    void delete(long id);

    void update(User user);

    List<User> findAll();


}
