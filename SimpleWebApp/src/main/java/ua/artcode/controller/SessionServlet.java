package ua.artcode.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = {"/count"})
public class SessionServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();// link to some cookie
        System.out.printf("session new %s, last access %tc, id %s",
                session.isNew(), session.getLastAccessedTime(), session.getId());

        int count = 1;

        if(session.isNew()){
            count = 1;
        } else {
            count = (Integer) session.getAttribute("count");
            ++count;
        }

        session.setAttribute("count", count);

        PrintWriter pw = resp.getWriter();
        pw.println("your count is " + count);
        pw.close();
    }
}
