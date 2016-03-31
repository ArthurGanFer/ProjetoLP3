package com.br.lp3.command;

import com.br.lp3.dao.UserLP3DAO;
import com.br.lp3.entities.UserLP3;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 1147106
 */
public class UserCommand implements Command {

    public HttpServletRequest request;
    public HttpServletResponse response;
    public String returnPage = "index.jsp";

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        String action = request.getParameter("action");
        request.getSession().setAttribute("errormsg", "");

        switch (action) {
            case "login":
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String check = request.getParameter("checkSave");

                UserLP3DAO dao = new UserLP3DAO();
                UserLP3 user = dao.readByUsername(username);

                if (user != null && user.getPassword().equals(password)) {
                    returnPage = "index.jsp";

                    if ("on".equals(check)) {
                        Cookie c = new Cookie("usernameCookie", username);
                        c.setMaxAge(60 * 60 * 24 * 7);
                        response.addCookie(c);
                        Cookie c2 = new Cookie("pwdCookie", password);
                        c.setMaxAge(60 * 60 * 24 * 7);
                        response.addCookie(c2);
                    } else {
                        Cookie c = new Cookie("usernameCookie", "");
                        c.setMaxAge(0);
                        response.addCookie(c);
                        Cookie c2 = new Cookie("pwdCookie", "");
                        c.setMaxAge(0);
                        response.addCookie(c2);
                    }

                    request.getSession().setAttribute("username", username);
                } else {
                    request.getSession().setAttribute("errormsg", "Usuario ou senha incorretos");
                    returnPage = "login.jsp";
                }
                break;
            case "logout":
                returnPage = "index.jsp";
                request.getSession().setAttribute("username", null);
                break;
            case "logerror":
                returnPage = "login.jsp";
                request.getSession().setAttribute("errormsg", "Acesso restrito! realize o login");
        }

    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }

}
