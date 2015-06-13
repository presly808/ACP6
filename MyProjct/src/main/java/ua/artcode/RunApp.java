package ua.artcode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.artcode.dao.HibernateUserDao;
import ua.artcode.dao.SimpleStorageUserDao;
import ua.artcode.dao.UserDao;
import ua.artcode.model.User;
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

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:app-context.xml");

        UserView userView = applicationContext.getBean(UserView.class);

        userView.start();
    }
}
