package ua.artcode.service;

import ua.artcode.dao.UserDao;
import ua.artcode.exception.LoginException;
import ua.artcode.exception.RegistrarException;
import ua.artcode.model.User;

import java.util.List;

/**
 * Created by serhii on 30.05.15.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;



    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public User register(String email, String fullname, String pass) throws RegistrarException {
        // validation
        User found = userDao.findByEmail(email);
        if(found != null){
            throw new RegistrarException("email already exists");
        }

        User newUser = new User(fullname,email,pass);

        return userDao.create(newUser);
    }

    public User login(String email, String pass) throws LoginException {

        User found = userDao.findByEmail(email);
        if(found == null){
            throw new LoginException("wrong email");
        }

        if(!found.getPass().equals(pass)){
            throw new LoginException("wrong pass");
        }

        return found;
    }

    public List<User> getAll() {
        return userDao.findAll();
    }


    public void logout() {
        //TODO finish this method
    }
}
