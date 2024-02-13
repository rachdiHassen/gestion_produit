package com.example.tpcat.dao;

import com.example.tpcat.metier.entities.Produit;

import java.util.List;

public interface IProduitDao {
    public Produit save (Produit p);
    public List<Produit> produitParMC(String mc);
    public Produit getProduit(int id);
    public Produit update(Produit p);
    public void deleteProduit(int id);
}
