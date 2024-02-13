<%@ page import="com.example.tpcat.web.ProduitModel" %>
<%@ page import="com.example.tpcat.metier.entities.Produit" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    ProduitModel model;
    if (request.getAttribute("model")!=null){
         model = (ProduitModel)request.getAttribute("model");
    }else{
        model=new ProduitModel();
    }

%>
<%@include file="header.jsp" %>
<html>
<head>
    <title>Produits</title>
</head>
<body>
    <div class="container">
        <form action="chercher.do" method="get">
        <label for="motCle"> Mot clé</label>
        <input type="text"   name="motCle" id="motCle">
        <button type="submit"> Chercher</button>
    </form>
    </div>
    <div class="container">
        <table>
            <tr>
                <th>ID</th><th>DESIGNATION</th><th>PRIX</th><th>QUANTITE</th>
            </tr>
            <% for(Produit p:model.getProduits()){%>
            <tr>
                <td><%=p.getId()%></td>
                <td><%=p.getDesignation()%></td>
                <td><%=p.getPrix()%></td>
                <td><%=p.getQuantite()%></td>
                <td> <a onclick="return confirm('ETES VOUS SUR??')" href="supprimer.do?id=<%=p.getId()%>">Supprimer</a> </td>
                <td> <a href="edit.do?id=<%=p.getId()%>">Edit</a> </td>
            </tr>
            <% }%>


        </table>
    </div>
</body>
</html>