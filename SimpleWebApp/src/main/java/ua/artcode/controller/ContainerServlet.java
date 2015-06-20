package ua.artcode.controller;

import ua.artcode.db.UserContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

// not valid
public class ContainerServlet extends HttpServlet {

    private UserContainer container;

    @Override
    public void init() throws ServletException {
        super.init();

        getServletContext().setAttribute("container",new UserContainer());
        container = new UserContainer();
    }

    public UserContainer getContainer() {
        return container;
    }
}
