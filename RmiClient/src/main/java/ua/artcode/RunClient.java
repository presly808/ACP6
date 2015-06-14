package ua.artcode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.artcode.model.User;
import ua.artcode.service.UserService;

import java.util.List;

/**
 * Hello world!
 *
 */
public class RunClient
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("client-context.xml");
        UserService service = applicationContext.getBean(UserService.class);

        List<User> userList = service.getAll();

        for (User user : userList) {
            System.out.println(user);
        }
    }
}
