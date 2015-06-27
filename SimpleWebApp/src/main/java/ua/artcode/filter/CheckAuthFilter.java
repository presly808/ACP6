package ua.artcode.filter;

import ua.artcode.db.UserContainer;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class CheckAuthFilter implements Filter {

    private UserContainer userContainer;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userContainer = (UserContainer) filterConfig.getServletContext().getAttribute("userList");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        Cookie[] cookies = httpReq.getCookies();
        Cookie found = find("userKey", cookies);

        if(found == null || !userContainer.isLogged(found.getValue())){
            //redirect
        } else {
            httpReq.setAttribute("currentUser", userContainer.getUserByKey(found.getValue()));
            chain.doFilter(httpReq,response);
        }


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

    @Override
    public void destroy() {

    }
}
