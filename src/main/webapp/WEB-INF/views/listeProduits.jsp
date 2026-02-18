<%--
  Created by IntelliJ IDEA.
  User: baha
  Date: 2/18/26
  Time: 12:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.stock.model.Produit, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>StockMaster Pro</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
<h1>Catalogue des Produits</h1>
<table border="1">
    <tr>
        <th>Nom</th>
        <th>Prix (TND)</th>
        <th>Quantité</th>
    </tr>
    <%
        List<Produit> produits = (List<Produit>) request.getAttribute("produits");
        for (Produit p : produits) {
    %>
    <tr>
        <td><%= p.getNom() %></td>
        <td><%= p.getPrix() %></td>
        <td><%= p.getQuantite() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>