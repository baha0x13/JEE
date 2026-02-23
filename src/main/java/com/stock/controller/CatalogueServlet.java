package com.stock.controller;

import com.stock.model.Produit;
import com.stock.service.IStockService;
import com.stock.service.impl.StockServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/catalogue")
public class CatalogueServlet extends HttpServlet {

    // La Servlet appelle le Service, jamais la DAO directement
    private IStockService service = new StockServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // --- Partie 4 : Gestion des Cookies ---
        // Lecture du cookie "lastVisit"
        String lastVisit = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("lastVisit".equals(c.getName())) {
                    lastVisit = URLDecoder.decode(c.getValue(), StandardCharsets.UTF_8);
                    break;
                }
            }
        }
        // Transmettre la valeur à la vue
        request.setAttribute("lastVisit", lastVisit);

        // Ecriture du nouveau cookie avec la date/heure actuelle
        String now = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        Cookie visitCookie = new Cookie("lastVisit",
                URLEncoder.encode(now, StandardCharsets.UTF_8));
        visitCookie.setMaxAge(24 * 60 * 60); // 24 heures
        visitCookie.setPath(request.getContextPath());
        response.addCookie(visitCookie);

        // --- Partie 1 : Récupération du catalogue via le Service ---
        List<Produit> liste = service.recupererCatalogueFiltre();
        request.setAttribute("listeProduits", liste);

        // Forward vers la vue protégée dans WEB-INF
        request.getRequestDispatcher("/WEB-INF/vues/catalogue.jsp")
                .forward(request, response);
    }
}
