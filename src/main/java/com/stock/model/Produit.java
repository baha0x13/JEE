package com.stock.model;

public class Produit {
    private int id;
    private String nom;
    private double prix;

    // Constructeur sans arguments (obligatoire pour un Java Bean)
    public Produit() {
    }

    public Produit(int id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    // Getters & Setters (obligatoires pour un Java Bean, utilisés par l'EL
    // ${produit.nom})
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}