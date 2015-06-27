package ua.artcode.controller;

import ua.artcode.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends ContainerServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");

        User user = getContainer().getUser(id);
        if(user == null){
            // forward to error page
        } else {
            // do login
            String key = UUID.randomUUID().toString();
            getContainer().addKeys(key,user);
            resp.addCookie(new Cookie("userKey", key));
        }

    }
}
