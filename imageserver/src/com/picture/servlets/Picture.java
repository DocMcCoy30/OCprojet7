package com.picture.servlets;

import com.picture.file.UploadFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(name = "/Picture")
public class Picture extends HttpServlet {
    private static final String cheminImage = "/static/";
    private String cheminFinalImage;

    // Indique l'adresse finale de stockage de tous les fichiers.
    private String cheminFichiers = null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        // les elements reçus sont codes en utf-8
        request.setCharacterEncoding("UTF-8");

        cheminFichiers = this.getServletContext().getInitParameter("rep_images");

        // Les elements envoyees sont codes en utf-8
        response.setCharacterEncoding("UTF-8");

        cheminFinalImage = cheminImage;

        request.setAttribute("cheminFinalImage", cheminFinalImage + "Default.png");

        // Association de la servlet a sa vue jsp
        this.getServletContext().getRequestDispatcher("/WEB-INF/addImage.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        boolean multipart = false;
        // multipart passe a true si quelqu'un a appuyé sur le bouton charger
        if (request.getContentType().substring(0, 19).equals("multipart/form-data")) {
            multipart = true;
            System.out.println("btn appuyé ");
        }

        if (multipart) {
            // Les données reçues sont multipart, on doit donc utiliser la méthode getPart() pour traiter le champ d'envoi de fichiers.
            Part filePart = request.getPart("fichier");

            // On vérifie qu'on a bien reçu un fichier
            String nomFichier = UploadFile.getNomFichier(filePart);

            // Si on a bien un fichier
            if (nomFichier != null && !nomFichier.isEmpty()) {

                // Corrige un bug du fonctionnement d'Internet Explorer
                nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1).substring(nomFichier.lastIndexOf('\\') + 1);

                // On écrit définitivement le fichier sur le disque
                System.out.println(cheminFichiers);
                UploadFile.ecrireFichier(filePart, cheminFichiers, nomFichier);

                cheminFinalImage = cheminImage + nomFichier;
                request.setAttribute("cheminFinalImage", cheminFinalImage);
            }
        }

        // Association de la servlet à sa vue jsp
        //-- Renvoi de la réponse
        this.getServletContext().getRequestDispatcher("/WEB-INF/addImage.jsp").forward(request, response);
    }
}
