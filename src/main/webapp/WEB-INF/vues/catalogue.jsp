<%@ page contentType="text/html;charset=UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Catalogue - StockMaster Pro</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
        </head>

        <body>
            <div class="container">
                <!-- Partie 2 : Affichage de l'utilisateur connecté -->
                <div class="nav">
                    <c:if test="${not empty sessionScope.user}">
                        <span>Utilisateur connecté : <strong>${sessionScope.user}</strong></span>
                        <a href="${pageContext.request.contextPath}/logout" class="btn-logout">Déconnexion</a>
                    </c:if>
                </div>

                <h1>Catalogue des Produits</h1>

                <!-- Partie 4 : Affichage de la dernière visite (Cookie) -->
                <c:if test="${not empty lastVisit}">
                    <p class="info-cookie">📅 Dernière visite : ${lastVisit}</p>
                </c:if>
                <c:if test="${empty lastVisit}">
                    <p class="info-cookie">📅 Bienvenue ! C'est votre première visite.</p>
                </c:if>

                <!-- Partie 1 : Affichage du tableau avec JSTL c:forEach et EL -->
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Prix (€)</th>
                    </tr>
                    <c:forEach var="produit" items="${listeProduits}">
                        <tr>
                            <td>${produit.id}</td>
                            <td>${produit.nom}</td>
                            <td>${produit.prix}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </body>

        </html>