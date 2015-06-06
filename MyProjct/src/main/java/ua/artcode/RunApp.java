package ua.artcode;

import ua.artcode.dao.HibernateUserDao;
import ua.artcode.dao.SimpleStorageUserDao;
import ua.artcode.dao.UserDao;
import ua.artcode.service.UserService;
import ua.artcode.service.UserServiceImpl;
import ua.artcode.storage.AppDataContainer;
import ua.artcode.view.ConsoleUserView;
import ua.artcode.view.UserView;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by serhii on 30.05.15.
 */
public class RunApp {

    public static void main(String[] args) {

        // find in ${CLASSPATH}/META-INF/persistence.xml
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("my_unit");

        UserDao userDao = new HibernateUserDao(factory);
        UserService userService = new UserServiceImpl(userDao);

        UserView userView = new ConsoleUserView(userService);

        userView.start();
    }
}
