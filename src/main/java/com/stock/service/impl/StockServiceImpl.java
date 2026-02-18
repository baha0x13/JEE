package com.stock.service.impl;

import com.stock.dao.IProduitDAO;
import com.stock.dao.mock.ProduitDAOMock;
import com.stock.model.Produit;
import com.stock.service.IStockService;
import java.util.List;
import java.util.stream.Collectors;

public class StockServiceImpl implements IStockService {

    private IProduitDAO dao = new ProduitDAOMock();

    @Override
    public List<Produit> recupererCatalogueFiltre() {
        // Logique métier : retourner seulement les produits en stock
        return dao.findAll()
                .stream()
                .filter(p -> p.getQuantite() > 0)
                .collect(Collectors.toList());
    }
}