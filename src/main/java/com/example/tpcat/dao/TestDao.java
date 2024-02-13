package com.example.tpcat.dao;

import com.example.tpcat.metier.entities.Produit;

import java.util.List;

public class TestDao {
    public static void main(String[] args) {
        ProduitDaoImpl p =new ProduitDaoImpl();
        Produit pr1= p.save(new Produit("HB 6580",900,20));
        Produit pr2= p.save(new Produit("IBM 7520",852.3,50));
        System.out.println(pr1.toString());
        System.out.println(pr2.toString());
        System.out.println("chercher des produits");
        List<Produit> list=p.produitParMC("%IBM%");
        for(Produit pr:list){
            System.out.println(pr.toString());
        }




    }
}
