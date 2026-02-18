package com.stock.controller;

import com.stock.model.Produit;
import com.stock.service.IStockService;
import com.stock.service.impl.StockServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;


@WebServlet("/produits")
public class ProduitServlet extends HttpServlet {

    private IStockService service = new StockServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Produit> liste = service.recupererCatalogueFiltre();
        request.setAttribute("produits", liste);
        request.getRequestDispatcher("/WEB-INF/views/listeProduits.jsp")
                .forward(request, response);
    }
}