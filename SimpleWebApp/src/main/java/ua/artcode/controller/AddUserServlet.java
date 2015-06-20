package ua.artcode.controller;

import org.omg.PortableServer.Servant;
import ua.artcode.db.UserContainer;
import ua.artcode.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/addUser"})
public class AddUserServlet extends ContainerServlet {

    public static final String APP_URL = "/SimpleWebApp";
    public static final String LOCATION = APP_URL + "/pages/success.html";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // validation
        String name = req.getParameter("name").trim();

        String strAge = req.getParameter("age").trim();
        int age = Integer.parseInt(strAge);

        User newUser = new User(name,age);
        getContainer().addUser(newUser);

        resp.sendRedirect(LOCATION);

    }
}
