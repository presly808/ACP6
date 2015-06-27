package ua.artcode.servlet;

import org.springframework.context.ApplicationContext;
import ua.artcode.model.User;
import ua.artcode.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by serhii on 21.06.15.
 */
public class ShowUsersServlet extends HttpServlet {

    public static final String PATH = "/WEB-INF/pages/user-list.jsp";
    private UserService userService;

    @Override
    public void init() throws ServletException {
        ApplicationContext applicationContext = (ApplicationContext) getServletContext()
                .getAttribute("springContext");
        userService = applicationContext.getBean(UserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = userService.getAll();
        req.setAttribute("users",userList);
        req.getRequestDispatcher(PATH).forward(req,resp);
    }
}
