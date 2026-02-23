package com.stock.controller;

import com.stock.model.User;
import com.stock.service.IStockService;
import com.stock.service.impl.StockServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/connexion")
public class LoginServlet extends HttpServlet {

    // La Servlet appelle le Service, jamais la DAO directement
    private IStockService service = new StockServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");

        // Authentification via la couche Service (qui appelle la DAO)
        User user = service.authentifier(login, pass);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user.getUsername());
            response.sendRedirect(request.getContextPath() + "/catalogue");
        } else {
            request.setAttribute("error", "Login ou mot de passe incorrect !");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
