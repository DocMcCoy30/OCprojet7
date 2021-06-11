package com.dmc30.clientui.shared;

import com.dmc30.clientui.service.contract.BibliothequeService;
import com.dmc30.clientui.service.contract.OuvrageService;
import com.dmc30.clientui.shared.bean.bibliotheque.*;
import com.dmc30.clientui.shared.bean.utilisateur.UtilisateurBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * Classe de methodes utilitaires utilisées à plusieurs reprises dans les controllers
 */
@Service
public class UtilsMethodService {

    BibliothequeService bibliothequeService;

    @Autowired
    public UtilsMethodService(BibliothequeService bibliothequeService) {
        this.bibliothequeService = bibliothequeService;
    }

    /**
     * Renvoie la bibliothèque selectionnée par l'utilisateur à la vue
     * @param theModel le ModeAndVue
     * @param bibliothequeId l'identifiant de la bibliothèque selectionnée
     */
    public void setBibliothequeForTheVue(ModelAndView theModel, @RequestParam("bibliothequeId") Long bibliothequeId) {
        if (bibliothequeId != null) {
            BibliothequeBean bibliotheque = bibliothequeService.getBibliothequeById(bibliothequeId);
            theModel.addObject("bibliotheque", bibliotheque);
        }
    }

    /**
     * Construit la liste de modèles Emprunt à renvoyer aux controllers et à la vue
     * @param empruntModelBeans la liste des emprunts à construire
     * @param pret le bean objet
     * @param empruntModelBean le bean empruntModel
     * @param abonne le bean abonné
     * @param ouvrageService le service ouvrage pour récupérer l'ouvrage emprunté
     */
    public void setEmpruntModelBean(List<EmpruntModelBean> empruntModelBeans, PretBean pret, EmpruntModelBean empruntModelBean, UtilisateurBean abonne, OuvrageService ouvrageService) {
        Date dateRetourPrevu;
        empruntModelBean.setAbonne(abonne.getPrenom() + " " + abonne.getNom());
        empruntModelBean.setAbonneId(abonne.getId());
        OuvrageResponseModelBean ouvrage = ouvrageService.getOuvrageById(pret.getOuvrageId());
        empruntModelBean.setIdentifiantOuvrage(ouvrage.getIdInterne());
        empruntModelBean.setTitreDuLivre(ouvrage.getTitre());
        empruntModelBean.setEmpruntId(pret.getId());
        empruntModelBean.setDateEmprunt(pret.getDateEmprunt());
        if (pret.isProlongation()) {
            dateRetourPrevu = pret.getDateProlongation();
        } else {
            dateRetourPrevu = pret.getDateRestitution();
        }
        empruntModelBean.setDateRetourPrevu(dateRetourPrevu);
        empruntModelBean.setProlongation(pret.isProlongation());
        empruntModelBeans.add(empruntModelBean);
    }

    /**
     * Methode utils pour remplir le formulaire de creation d'un emprunt avec les détails nécessaires de l'ouvrage selectionné
     * et le renvoyer aux controllers et à la vue
     * @param createEmpruntBean l'objet createEmprunt correspondant au formulaire pour la vue
     * @param ouvrageSelectionne l'ouvrage à emprunter
     */
    public void setOuvrageForEmpruntBean(@ModelAttribute CreateEmpruntBean createEmpruntBean, OuvrageResponseModelBean ouvrageSelectionne) {
        createEmpruntBean.setOuvrageId(ouvrageSelectionne.getId());
        createEmpruntBean.setIdInterne(ouvrageSelectionne.getIdInterne());
        createEmpruntBean.setTitre(ouvrageSelectionne.getTitre());
        createEmpruntBean.setAuteur(ouvrageSelectionne.getAuteur());
    }

    /**
     * Methode utils pour remplir le formulaire de création d'un emprunt avec les détails nécessaires de l'abonné selectionné
     * et le renvoyer aux controllers et à la vue
     * @param createEmpruntBean l'objet createEmprunt correspondant au formulaire pour la vue
     * @param abonneSelectionne l'abonné qui souhaite effectuer un emprunt
     */
    public void setAbonneForEmpruntBean(@ModelAttribute CreateEmpruntBean createEmpruntBean, UtilisateurBean abonneSelectionne) {
        createEmpruntBean.setAbonneId(abonneSelectionne.getId());
        createEmpruntBean.setNumAbonne(abonneSelectionne.getNumAbonne());
        createEmpruntBean.setPrenom(abonneSelectionne.getPrenom());
        createEmpruntBean.setNom(abonneSelectionne.getNom());
        createEmpruntBean.setNumTelephone(abonneSelectionne.getNumTelephone());
    }
}
