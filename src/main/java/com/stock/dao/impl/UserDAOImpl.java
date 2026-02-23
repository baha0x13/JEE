package com.stock.dao.impl;

import com.stock.dao.IUserDAO;
import com.stock.model.User;
import java.sql.*;

public class UserDAOImpl implements IUserDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/stockmaster";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "baha1919@@";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver MySQL introuvable !", e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, DB_USER, DB_PASS);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT id, username, password FROM users WHERE username = ? AND password = ?";

        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    return user;
                }
            }

        } catch (SQLException e) {
            System.err.println("Erreur SQL dans findByUsernameAndPassword() : " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
