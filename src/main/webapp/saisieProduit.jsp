<%@include file="header.jsp" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>saisie produits</title>
</head>
<body>

    <form action="saveProduit.do" method="POST">
        <div>
            <label for="designation"> entrer designation</label>
            <input type="text" name="designation" id="designation" placeholder="" required>
        </div>
        <div>
            <label for="prix"> entrer prix</label>
            <input type="text" name="prix" id="prix" placeholder="0.0">
        </div>
        <div>
            <label for="quantite"> entrer quantite</label>
            <input type="text" name="quantite" id="quantite" placeholder="0">
        </div>
        <div>
            <button type="submit"> Save</button>
        </div>
    </form>

</body>
</html>