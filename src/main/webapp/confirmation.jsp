<%@ page import="com.example.tpcat.metier.entities.Produit" %>
<%@include file="header.jsp" %>
<%
    Produit p =(Produit)request.getAttribute("produit");
%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>saisie produits</title>
</head>
<body>


    <div>
        <label > ID</label>
        <label> <%= p.getId() %></label>
    </div>
    <div>
        <label > designation</label>
        <label> <%= p.getDesignation() %></label>
    </div>
    <div>
        <label > Prix</label>
        <label> <%= p.getPrix() %></label>
    </div>
    <div>
        <label > Quantite</label>
        <label> <%= p.getQuantite() %></label>
    </div>

</body>
</html>