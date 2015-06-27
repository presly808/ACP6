package ua.artcode.controller;

import ua.artcode.db.UserContainer;
import ua.artcode.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

// not valid
public class ContainerServlet extends HttpServlet {

    private UserContainer container;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        container = (UserContainer) context.getAttribute("userList");
    }

    public UserContainer getContainer() {
        return container;
    }

}
