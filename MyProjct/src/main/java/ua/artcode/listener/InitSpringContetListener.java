package ua.artcode.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by serhii on 21.06.15.
 */
public class InitSpringContetListener implements ServletContextListener{


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String path = servletContext.getInitParameter("spring-location");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
        servletContext.setAttribute("springContext", applicationContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
