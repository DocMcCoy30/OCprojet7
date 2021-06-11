# DownloadPicture

* URL du client :
    http://localhost:8081/imageserver/

* URL pour appeler le servlet d'upload d'une image
  http://localhost:8081/imageserver/addImage

  * Tester l'appel à une image présente dans le serveur (download).
  http://localhost:8081/imageserver/static/bougies.jpg

* Deux chemins à modifier dans le fichier web.xml

  Ligne 20 :
    <param-value>D:\OFA_PROJECT\INTELLIJ_workspace\OFA_ImageServer\web\public\images</param-value>

  Ligne 33 :
    <location>D:\Test\images\</location>

# Configuration IntelliJ
![Edit configurations Image Server](.\documentation\screenshots\Config_Image_Server.png)
