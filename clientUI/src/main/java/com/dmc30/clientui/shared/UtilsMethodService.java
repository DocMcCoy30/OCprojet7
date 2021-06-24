package com.dmc30.clientui.shared;

import com.dmc30.clientui.service.contract.BibliothequeService;
import com.dmc30.clientui.service.contract.EmpruntService;
import com.dmc30.clientui.service.contract.OuvrageService;
import com.dmc30.clientui.service.contract.UserService;
import com.dmc30.clientui.shared.bean.bibliotheque.*;
import com.dmc30.clientui.shared.bean.utilisateur.UtilisateurBean;
import com.dmc30.clientui.web.exception.TechnicalException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe de methodes génériques utilisées à plusieurs reprises dans les controllers : ne pas multiplier les lignes de code : refactoring...
 */
@Service
public class UtilsMethodService {

    BibliothequeService bibliothequeService;
    OuvrageService ouvrageService;
    EmpruntService empruntService;
    UserService userService;

    @Autowired
    public UtilsMethodService(BibliothequeService bibliothequeService,
                              OuvrageService ouvrageService,
                              EmpruntService empruntService,
                              UserService userService) {
        this.bibliothequeService = bibliothequeService;
        this.ouvrageService = ouvrageService;
        this.empruntService = empruntService;
        this.userService = userService;
    }

    /**
     * Renvoie la bibliothèque selectionnée par l'utilisateur à la vue
     *
     * @param theModel       le ModeAndVue
     * @param bibliothequeId l'identifiant de la bibliothèque selectionnée
     */
    public void setBibliothequeForTheVue(ModelAndView theModel, @RequestParam("bibliothequeId") Long bibliothequeId) {
        String errorMessage;
        if (bibliothequeId != null) {
            ResponseEntity<?> response = bibliothequeService.getBibliothequeById(bibliothequeId);
            if (response.getStatusCodeValue() == 202) {
                ObjectMapper mapper = new ObjectMapper();
                BibliothequeBean bibliotheque = mapper.convertValue(response.getBody(), BibliothequeBean.class);
                theModel.addObject("bibliotheque", bibliotheque);
            } else if (response.getStatusCodeValue() == 491) {
                errorMessage = (String) response.getBody();
                theModel.addObject("errorMessage", errorMessage);
            } else if (response.getStatusCodeValue() == 490) {
                errorMessage = (String) response.getBody();
                theModel.addObject("errorMessage", errorMessage);
            }
        }
    }

    /**
     * Construit la liste de modèles Emprunt à renvoyer aux controllers et à la vue
     *
     * @param empruntModelBeans la liste des emprunts à construire
     * @param pret              le bean objet
     * @param empruntModelBean  le bean empruntModel
     * @param abonne            le bean abonné
     * @param ouvrageService    le service ouvrage pour récupérer l'ouvrage emprunté
     */
    public void setEmpruntModelBean(List<EmpruntModelBean> empruntModelBeans, PretBean pret, EmpruntModelBean empruntModelBean, UtilisateurBean abonne, OuvrageService ouvrageService) throws TechnicalException {
        Date dateRestitution;
        empruntModelBean.setAbonne(abonne.getPrenom() + " " + abonne.getNom());
        empruntModelBean.setAbonneId(abonne.getId());
        OuvrageResponseModelBean ouvrage = ouvrageService.getOuvrageById(pret.getOuvrageId());
        empruntModelBean.setIdentifiantOuvrage(ouvrage.getIdInterne());
        empruntModelBean.setTitreDuLivre(ouvrage.getTitre());
        empruntModelBean.setAuteur(ouvrage.getAuteur());
        empruntModelBean.setEmpruntId(pret.getId());
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd MMMMM yyyy");
        empruntModelBean.setDateEmpruntFormat(dateFormat.format(pret.getDateEmprunt()));
        empruntModelBean.setDateEmprunt(pret.getDateEmprunt());
        if (pret.isProlongation()) {
            dateRestitution = pret.getDateProlongation();
        } else {
            dateRestitution = pret.getDateRestitution();
        }
        if (pret.isRestitution()) {
            dateRestitution = pret.getDateRestitution();
        }
        empruntModelBean.setDateRetour(dateRestitution);
        empruntModelBean.setDateRetourFormat(dateFormat.format(dateRestitution));
        empruntModelBean.setProlongation(pret.isProlongation());
        empruntModelBeans.add(empruntModelBean);
    }

    /**
     * Methode utils pour remplir le formulaire de creation d'un emprunt avec les détails nécessaires de l'ouvrage selectionné
     * et le renvoyer aux controllers et à la vue
     *
     * @param createEmpruntBean  l'objet createEmprunt correspondant au formulaire pour la vue
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
     *
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

    /**
     * Methode utils pour formater la liste la liste des emprunts en cours par bibliotheque (ROLE-EMPLOYE)
     *
     * @param theModel          le ModelAndView
     * @param empruntModelBeans La liste d'objets EmpruntModel à renvoyer à la vue
     * @param bibliothequeId    l'identifiant de la bibliothèque
     */
    public void setEmpruntsEnCours(ModelAndView theModel, List<EmpruntModelBean> empruntModelBeans, @RequestParam("bibliothequeId") Long bibliothequeId) {
        String message;
        try {
            List<PretBean> empruntsEnCours = empruntService.getEmpruntsEnCours(bibliothequeId);
            if (empruntsEnCours.isEmpty()) {
                ResponseEntity<?> response = bibliothequeService.getBibliothequeById(bibliothequeId);
                ObjectMapper mapper = new ObjectMapper();
                BibliothequeBean bibliotheque = mapper.convertValue(response.getBody(), BibliothequeBean.class);
                message = "Aucun emprunt en cours pour " + bibliotheque.getNom();
                theModel.addObject("message", message);
            } else {
                for (PretBean pret : empruntsEnCours) {
                    EmpruntModelBean empruntModelBean = new EmpruntModelBean();
                    UtilisateurBean abonne = userService.getUtilisateurById(pret.getUtilisateurId());
                    setEmpruntModelBean(empruntModelBeans, pret, empruntModelBean, abonne, ouvrageService);
                }
                theModel.addObject("empruntEnCours", empruntModelBeans);
            }
        } catch (TechnicalException e) {
            String errorMessage = e.getMessage();
            theModel.addObject("errorMessage", errorMessage);
        }
    }

    /**
     * Methode utils pour formater la liste des emprunts (en cours et historique) pour un abonné (ROLE-ABONNE)
     *
     * @param username     le username de l'abonné
     * @param theModel     le ModelAndView
     * @param modification la demande de modification du profil => false dans ce cas
     */
    public void setEmpruntListForProfilView(String username, ModelAndView theModel, boolean modification) {
        String message;
        UtilisateurBean abonne = userService.getUtilisateurByUsername(username);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        abonne.setDateCreationCompteFormat(dateFormat.format(abonne.getDateCreationCompte()));
        List<EmpruntModelBean> empruntsEnCours = new ArrayList<>();
        List<EmpruntModelBean> empruntsRetournes = new ArrayList<>();
        Long utilisateurId = abonne.getId();
        try {
            List<PretBean> empruntList = empruntService.getEmpruntByUtilisateurId(utilisateurId);
            if (empruntList.isEmpty()) {
                message = "Aucun emprunt en cours";
                theModel.addObject("message", message);
            } else {
                for (PretBean pret : empruntList) {
                    EmpruntModelBean empruntModelBean = new EmpruntModelBean();
                    if (pret.isRestitution()) {
                        setEmpruntModelBean(empruntsRetournes, pret, empruntModelBean, abonne, ouvrageService);
                        theModel.addObject("empruntsRetournes", empruntsRetournes);
                    } else if (!pret.isRestitution()) {
                        setEmpruntModelBean(empruntsEnCours, pret, empruntModelBean, abonne, ouvrageService);
                        theModel.addObject("empruntEnCours", empruntsEnCours);
                    }
                }
            }
            theModel.addObject("abonne", abonne);
            theModel.addObject("modification", modification);
        } catch (TechnicalException e) {
            String errorMessage = e.getMessage();
            theModel.addObject("errorMessage", errorMessage);
        }
    }
}
