package ua.artcode.controller;

import ua.artcode.db.UserContainer;
import ua.artcode.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(urlPatterns = {"/showUsers"})
public class ShowUsersServlet extends ContainerServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Collection<User> usersList = getContainer().userList();
        PrintWriter pw = resp.getWriter();

        for (User user : usersList) {
            pw.println(user);
        }

        pw.close();
    }
}
