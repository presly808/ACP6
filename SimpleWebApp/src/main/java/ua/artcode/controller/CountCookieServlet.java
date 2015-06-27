package ua.artcode.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet
public class CountCookieServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //


    }

    private Cookie find(String name, Cookie[] cookies){
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())){
                    return cookie;
                }
            }
        }
        return null;
    }

}
