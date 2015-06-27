package ua.artcode.listener;

import ua.artcode.db.UserContainer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String appURL = servletContext.getInitParameter("APP_URL");
        servletContext.setAttribute("APP_URL", appURL);
        servletContext.setAttribute("userList", new UserContainer());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
