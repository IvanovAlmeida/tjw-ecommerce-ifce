package br.edu.ifce.controller;

import br.edu.ifce.dao.ItemDAO;
import br.edu.ifce.model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", value = "/")
public class HomeController extends BaseServlet {
    private final ItemDAO itemDAO;

    public HomeController() {
        itemDAO = new ItemDAO();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> items = itemDAO.ListAll();

        request.setAttribute("items", items);
        View("views/home/index.jsp");
    }
}
