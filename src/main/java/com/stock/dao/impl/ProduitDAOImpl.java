package com.stock.dao.impl;

import com.stock.dao.IProduitDAO;
import com.stock.model.Produit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAOImpl implements IProduitDAO {

    // Paramètres de connexion MySQL (localhost)
    private static final String URL = "jdbc:mysql://localhost:3306/stockmaster";
    private static final String USER = "root";
    private static final String PASSWORD = "baha1919@@";

    // Chargement du driver JDBC
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver MySQL introuvable !", e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public List<Produit> findAll() {
        List<Produit> produits = new ArrayList<>();
        String sql = "SELECT id, nom, prix FROM produits";

        // try-with-resources : fermeture automatique des ressources
        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setPrix(rs.getDouble("prix"));
                produits.add(p);
            }

        } catch (SQLException e) {
            System.err.println("Erreur SQL dans findAll() : " + e.getMessage());
            e.printStackTrace();
        }

        return produits;
    }

    @Override
    public void add(Produit p) {
        String sql = "INSERT INTO produits (nom, prix) VALUES (?, ?)";

        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrix());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erreur SQL dans add() : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
