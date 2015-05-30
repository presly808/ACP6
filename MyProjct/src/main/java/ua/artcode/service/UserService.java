package ua.artcode.service;

import ua.artcode.exception.LoginException;
import ua.artcode.exception.RegistrarException;
import ua.artcode.model.User;

import java.util.List;

/**
 * Created by serhii on 30.05.15.
 */
public interface UserService {

    User register(String email,
                  String fullname, String pass) throws RegistrarException;

    User login(String email, String pass) throws LoginException;

    List<User> getAll();

    void logout();

}
