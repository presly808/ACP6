package ua.artcode.dao;

import ua.artcode.model.User;
import ua.artcode.storage.AppDataContainer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by serhii on 30.05.15.
 */
public class SimpleStorageUserDao implements UserDao{

    private AppDataContainer container;

    public SimpleStorageUserDao(AppDataContainer container) {
        this.container = container;
    }

    public User create(User user) {
        long id = container.getUsers().size() + 1;
        container.getUsers().put(id, user);
        user.setId(id);

        return user;
    }

    public User findByEmail(String email) {
        for(User user : container.getUsers().values()){
            if(user.getEmail().equals(email)){
                return user;
            }
        }

        return null;
    }

    public User findById(long id) {
        return container.getUsers().get(id);
    }

    public void delete(long id) {
        container.getUsers().remove(id);
    }

    public void update(User user) {
        container.getUsers().put(user.getId(), user);
    }

    public List<User> findAll() {
        List<User> users = new LinkedList<User>();
        for(User user : container.getUsers().values()){
            users.add(user);
        }
        return users;
    }
}
