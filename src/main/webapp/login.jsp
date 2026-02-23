<%@ page contentType="text/html;charset=UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Connexion - StockMaster Pro</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
        </head>

        <body>
            <div class="container">
                <h1>Connexion</h1>

                <!-- Affichage du message d'erreur (du filtre ou du login raté) -->
                <c:if test="${not empty error}">
                    <p class="error">${error}</p>
                </c:if>
                <c:if test="${param.error == '1'}">
                    <p class="error">Veuillez vous connecter pour accéder au catalogue.</p>
                </c:if>

                <form action="${pageContext.request.contextPath}/connexion" method="post">
                    <div class="form-group">
                        <label for="login">Login :</label>
                        <input type="text" id="login" name="login" required>
                    </div>
                    <div class="form-group">
                        <label for="pass">Mot de passe :</label>
                        <input type="password" id="pass" name="pass" required>
                    </div>
                    <button type="submit">Se connecter</button>
                </form>
            </div>
        </body>

        </html>