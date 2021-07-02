package br.edu.ifce.controller;

import br.edu.ifce.dao.UserDAO;
import br.edu.ifce.model.User;
import br.edu.ifce.utils.BeanUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends BaseServlet {
    private final UserDAO userDAO;

    public RegisterController(){
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        View("views/register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = new User();
        BeanUtilities.populateBean(u, request);

        if(userDAO.VerifyIfUsedEmail(u.getEmail())) {
            AddError("Email em uso!");
            View("views/register.jsp");
            return;
        }

        userDAO.Insert(u);
        SetSession(u, request.getSession());
        response.sendRedirect("/items");
    }

    private void SetSession(User u, HttpSession session) {
        session.setAttribute("id", u.getId());
        session.setAttribute("name", u.getName());
        session.setAttribute("email", u.getEmail());
    }
}
