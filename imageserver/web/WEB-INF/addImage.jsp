<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style type="text/css">
        <%@include file="../public/css/style.css" %>
    </style>
    <title>Download new Picture</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-1"></div>
        <!-- BLOC TÉLÉCHARGER UNE IMAGE-->
        <div class="jumbotron col-lg-4">
            <h1 class="display-6">Télécharger une image</h1>
            <hr class="my-4">
            <form method="post" action="<%=request.getContextPath()%>/addImage" enctype="multipart/form-data">
                <div class="row">
                    <div class="uploadImage col-lg-4 offset-lg-4">
                        <img src="<%=request.getContextPath()%>/static/default.png" class="img-fluid" id="output" alt="Responsive image">
                    </div>
                    <div class="col-lg-4"></div>
                    <div class="uploadImage col-lg-4">
                        <input type="file" name="fichier" id="fichier" class="btn-primary" accept="image/*" onchange="loadFile(event)" />
                    </div>
                    <div class="col-lg-8"></div>
                    <div id="fileOpen3 " class="uploadImage col-lg-4"><input class="btn btn-primary btn-sm " type="submit" value="Charger" id="newImage" name="btnCharger"/>
                    </div>
                    <div class="col-lg-8"></div>
                </div>
            </form>
        </div>

        <div class="col-lg-2"></div>
        <!-- BLOC AFFICHER IMAGE TÉLÉCHARGER-->
        <div class="jumbotron col-lg-4">
            <div class="container">
                <h1 class="display-6">Affichage de l'image téléchargée</h1>
                <hr class="my-4">
                <div class="row">
                    <div class="uploadImage col-lg-4 offset-lg-4">
                        <img src="<%=request.getContextPath()%>${cheminFinalImage}" class="img-fluid" alt="Responsive image"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-1"></div>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/js/pictureDisplay.js"></script>
</body>
</html>

