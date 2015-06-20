package ua.artcode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class HelloWordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getQueryString();
        String method = req.getMethod();
        String host = req.getRemoteHost();
        int port = req.getRemotePort();

        String message = String.format("query : %s, method : %s, " +
                        "host : %s, port : %d",
                query, method, host, port);

        // server log
        System.out.println(message);

        // send to client
        PrintWriter pw = resp.getWriter();
        pw.printf("Hi, from Server, %s, %tc", message, new Date());
        pw.flush();
        pw.close();
    }
}
