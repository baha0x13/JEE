package com.stock.dao.mock;

import com.stock.dao.IProduitDAO;
import com.stock.model.Produit;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAOMock implements IProduitDAO {

    private static List<Produit> catalogue = new ArrayList<>();

    static {
        catalogue.add(new Produit(1, "Clavier", 25.0));
        catalogue.add(new Produit(2, "Souris Logitech", 35.50));
        catalogue.add(new Produit(3, "Écran 24 pouces", 350.00));
    }

    @Override
    public List<Produit> findAll() {
        return catalogue;
    }

    @Override
    public void add(Produit p) {
        catalogue.add(p);
    }
}