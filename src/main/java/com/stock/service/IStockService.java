package com.stock.service;

import com.stock.model.Produit;
import com.stock.model.User;
import java.util.List;

public interface IStockService {
    List<Produit> recupererCatalogueFiltre();

    User authentifier(String username, String password);
}