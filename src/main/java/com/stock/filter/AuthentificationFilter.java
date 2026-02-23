package com.stock.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/catalogue")
public class AuthentificationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Vérifier si l'objet "user" existe en session
        HttpSession session = httpRequest.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            // L'utilisateur est connecté : laisser passer la requête
            chain.doFilter(request, response);
        } else {
            // L'utilisateur n'est PAS connecté : rediriger vers login.jsp avec message
            // d'erreur
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp?error=1");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialisation du filtre (si nécessaire)
    }

    @Override
    public void destroy() {
        // Nettoyage du filtre (si nécessaire)
    }
}
