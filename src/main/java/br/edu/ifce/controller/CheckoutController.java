package br.edu.ifce.controller;

import br.edu.ifce.model.CartItem;
import br.edu.ifce.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CheckoutController", value = "/checkout")
public class CheckoutController extends BaseServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        needsAuthentication = true;

        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CartItem> cart = (List<CartItem>)request.getSession().getAttribute("cart");

        double valorTotal = GetTotalCartValue(cart);

        request.setAttribute("TotalValue", StringUtils.FormatForMoney(valorTotal));
        request.setAttribute("Cart", cart);

        request.getSession().setAttribute("cart", new ArrayList<CartItem>());

        View("views/checkout/index.jsp");
    }

    private double GetTotalCartValue(List<CartItem> cart) {
        double totalPrice = 0d;

        for(CartItem item : cart) {
            totalPrice += item.getTotalPrice();
        }

        return totalPrice;
    }
}
