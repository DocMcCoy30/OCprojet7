package com.picture.file;


import javax.servlet.http.Part;
import java.io.*;

public abstract class UploadFile {

    // Permet de faire la copie du fichier temporaire vers le dossier final
    private static final int TAILLE_TAMPON = 102400;

    // Découpe l'entete http du fichier et récupère le nom du fichier que l'on à upload
    public static String getNomFichier(Part part) {
        for (String contentDisposition : part.getHeader("content-disposition").split(";")) {
            if (contentDisposition.trim().startsWith("filename")) {
                return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    // Écriture du fichier dans le dossier final
    public static void ecrireFichier(Part part, String cheminFichier, String nomFichier) throws IOException {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(cheminFichier + "\\" + nomFichier)), TAILLE_TAMPON);

            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
        } finally {
            try {
                sortie.close();
            } catch (IOException ignore) {
            }
            try {
                entree.close();
            } catch (IOException ignore) {
            }
        }
    }
}