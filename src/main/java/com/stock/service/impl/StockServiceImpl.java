package com.stock.service.impl;

import com.stock.dao.IProduitDAO;
import com.stock.dao.IUserDAO;
import com.stock.dao.impl.ProduitDAOImpl;
import com.stock.dao.impl.UserDAOImpl;
import com.stock.model.Produit;
import com.stock.model.User;
import com.stock.service.IStockService;
import java.util.List;

public class StockServiceImpl implements IStockService {

    // Le service possède des instances des interfaces DAO
    private IProduitDAO produitDAO = new ProduitDAOImpl();
    private IUserDAO userDAO = new UserDAOImpl();

    @Override
    public List<Produit> recupererCatalogueFiltre() {
        return produitDAO.findAll();
    }

    @Override
    public User authentifier(String username, String password) {
        return userDAO.findByUsernameAndPassword(username, password);
    }
}