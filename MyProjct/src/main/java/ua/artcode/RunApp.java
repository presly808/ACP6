package ua.artcode;

import ua.artcode.dao.SimpleStorageUserDao;
import ua.artcode.dao.UserDao;
import ua.artcode.service.UserService;
import ua.artcode.service.UserServiceImpl;
import ua.artcode.storage.AppDataContainer;
import ua.artcode.view.ConsoleUserView;
import ua.artcode.view.UserView;

/**
 * Created by serhii on 30.05.15.
 */
public class RunApp {

    public static void main(String[] args) {
        AppDataContainer container = new AppDataContainer();
        UserDao userDao = new SimpleStorageUserDao(container);
        UserService userService = new UserServiceImpl(userDao);

        UserView userView = new ConsoleUserView(userService);

        userView.start();
    }
}
