package com.example.tpcat.dao;

import com.example.tpcat.metier.entities.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDaoImpl implements IProduitDao {
    @Override
    public Produit save(Produit p) {
        Connection connection=SingletonConnection.getConnection();
        try {
        PreparedStatement ps=connection.prepareStatement
                ("INSERT INTO PRODUIT (DESIGNATION,PRIX,QUANTITE) VALUES(?,?,?)");

            ps.setString(1,p.getDesignation());
            ps.setDouble(2,p.getPrix());
            ps.setInt(3,p.getQuantite());
            ps.executeUpdate();
            PreparedStatement ps2=connection.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM PRODUIT");
            ResultSet rs= ps2.executeQuery();
            if(rs.next()){
                p.setId(rs.getInt("MAX_ID"));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;

    }

    @Override
    public List<Produit> produitParMC(String mc) {
        Connection connection=SingletonConnection.getConnection();
        List<Produit> produits= new ArrayList<>();
        try {
            PreparedStatement ps=connection.prepareStatement
                    ("SELECT * FROM PRODUIT WHERE DESIGNATION LIKE CONCAT( '%',?,'%')");

             ps.setString(1,mc);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
               Produit produit=new Produit();
               produit.setId(rs.getInt("ID"));
               produit.setDesignation(rs.getString("DESIGNATION"));
               produit.setPrix(rs.getDouble("PRIX"));
               produit.setQuantite(rs.getInt("QUANTITE"));
               produits.add(produit);
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }

    @Override
    public Produit getProduit(int id) {
        Connection connection=SingletonConnection.getConnection();
        Produit produit=null;
        try {
            PreparedStatement ps=connection.prepareStatement
                    ("SELECT * FROM PRODUIT WHERE ID=?");

            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                produit=new Produit();
                produit.setId(rs.getInt("ID"));
                produit.setDesignation(rs.getString("DESIGNATION"));
                produit.setPrix(rs.getDouble("PRIX"));
                produit.setQuantite(rs.getInt("QUANTITE"));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produit;

    }

    @Override
    public Produit update(Produit p) {
        Connection connection=SingletonConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement
                    ("UPDATE PRODUIT SET DESIGNATION=?,PRIX=?,QUANTITE=? WHERE ID=?");

            ps.setString(1,p.getDesignation());
            ps.setDouble(2,p.getPrix());
            ps.setInt(3,p.getQuantite());
            ps.setInt(4,p.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void deleteProduit(int id) {
        Connection connection=SingletonConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement
                    ("DELETE FROM PRODUIT WHERE ID=?");

            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
