<%@ page import="com.example.tpcat.metier.entities.Produit" %>
<%@include file="header.jsp" %>
<%
    Produit p= (Produit) request.getAttribute("produit");
%>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>saisie produits</title>
</head>
<body>

<form action="updateProduit.do" method="POST">
    <div>
        <label> ID</label>
        <input type="text" name="id" value="<%= p.getId()%>" readonly>
    </div>
    <div>
        <label> designation</label>
        <input type="text" name="designation" value="<%= p.getDesignation()%>">
    </div>
    <div>
        <label> prix</label>
        <input type="text" name="prix" value="<%= p.getPrix()%>">
    </div>
    <div>
        <label> quantite</label>
        <input type="text" name="quantite" value="<%= p.getQuantite()%>" >
    </div>
    <div>
        <button type="submit"> Update</button>
    </div>
</form>

</body>
</html>