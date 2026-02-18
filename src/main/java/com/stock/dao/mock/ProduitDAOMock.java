package com.stock.dao.mock;

import com.stock.dao.IProduitDAO;
import com.stock.model.Produit;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAOMock implements IProduitDAO {

    private static List<Produit> catalogue = new ArrayList<>();

    static {
        catalogue.add(new Produit(1, "Laptop Dell", 1200.00, 15));
        catalogue.add(new Produit(2, "Souris Logitech", 25.50, 100));
        catalogue.add(new Produit(3, "Clavier Mécanique", 75.00, 20));
        catalogue.add(new Produit(4, "Écran 24 pouces", 350.00, 8));
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