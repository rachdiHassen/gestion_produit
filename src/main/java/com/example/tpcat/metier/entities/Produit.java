package com.example.tpcat.metier.entities;

import java.io.Serializable;

public class Produit implements Serializable {
    private int id;
    private String designation;
    private double prix;
    private int quantite;

    public Produit() {

    }

    public Produit(String designation, double prix, int quantite) {
        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Produit{id=" + id + ", designation=" + designation  + ", prix=" + prix + ", quantite=" + quantite + '}';
    }
}
