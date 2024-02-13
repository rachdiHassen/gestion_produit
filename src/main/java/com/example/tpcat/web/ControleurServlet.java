package com.example.tpcat.web;

import com.example.tpcat.dao.IProduitDao;
import com.example.tpcat.dao.ProduitDaoImpl;
import com.example.tpcat.metier.entities.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ControleurServlet extends HttpServlet {
    private IProduitDao metier;

    @Override
    public void init() throws ServletException {
        metier=new ProduitDaoImpl();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path= request.getServletPath();
        if (path.equals("/index.do")){
            request.getRequestDispatcher("produits.jsp").forward(request,response);
        }
        else if (path.equals("/chercher.do")) {
            ProduitModel model=new ProduitModel();
            String mc=request.getParameter("motCle");
            List<Produit> produits=metier.produitParMC(mc);
            model.setMotCle(mc);
            model.setProduits(produits);
            request.setAttribute("model",model);
            request.getRequestDispatcher("produits.jsp").forward(request,response);
        }
        else if (path.equals("/saveProduit.do") && request.getMethod().equals("POST")){
            String designation=request.getParameter("designation");
            double prix=Double.parseDouble(request.getParameter("prix"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            Produit p =metier.save(new Produit(designation,prix,quantite));
            request.setAttribute("produit",p);
            request.getRequestDispatcher("confirmation.jsp").forward(request,response);

        }
        else if (path.equals("/supprimer.do")) {
            int id =Integer.parseInt(request.getParameter("id")) ;
            metier.deleteProduit(id);
            //request.getRequestDispatcher("produits.jsp").forward(request,response);
            response.sendRedirect("chercher.do?motCle= ");
        }

        else if (path.equals("/edit.do")) {
            ProduitModel model=new ProduitModel();
            int id =Integer.parseInt(request.getParameter("id"));
            Produit produit=metier.getProduit(id);
            request.setAttribute("produit",produit);
            request.getRequestDispatcher("editProduit.jsp").forward(request,response);

        }
        else if (path.equals("/updateProduit.do") && request.getMethod().equals("POST")) {
            Produit p;
            int id=Integer.parseInt(request.getParameter("id"));
            String designation=request.getParameter("designation");
            double prix=Double.parseDouble(request.getParameter("prix"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            p =new Produit(designation,prix,quantite);
            p.setId(id);
            metier.update(p);
            request.setAttribute("produit",p);
            request.getRequestDispatcher("confirmation.jsp").forward(request,response);
        } else{
            response.sendError(response.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    public void destroy() {

    }
}
