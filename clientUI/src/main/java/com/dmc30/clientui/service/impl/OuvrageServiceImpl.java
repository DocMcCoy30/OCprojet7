package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.shared.bean.bibliotheque.CreateEmpruntBean;
import com.dmc30.clientui.proxy.LivreServiceProxy;
import com.dmc30.clientui.service.contract.LivreService;
import com.dmc30.clientui.service.contract.OuvrageService;
import com.dmc30.clientui.shared.bean.bibliotheque.OuvrageBean;
import com.dmc30.clientui.shared.bean.bibliotheque.OuvrageResponseModelBean;
import com.dmc30.clientui.shared.bean.livre.LivreBean;
import com.dmc30.clientui.shared.bean.utilisateur.UtilisateurBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OuvrageServiceImpl implements OuvrageService {

    LivreServiceProxy livreServiceProxy;
    LivreService livreService;

    @Autowired
    public OuvrageServiceImpl(LivreServiceProxy livreServiceProxy, LivreService livreService) {
        this.livreServiceProxy = livreServiceProxy;
        this.livreService = livreService;
    }

    /**
     * Cherche le nombre d'exemplaire disponible d'un ouvrage dans la bibliothèque selectionnée
     * @param livreId l'identifiant du livre correspondant à l'ouvrage recherché
     * @param bibliothequeId l'identifiant de la bibliothèque selectionnée
     * @return le nombre d'exemplaire de l'ouvrage
     */
    @Override
    public Integer getOuvrageDispoInOneBibliotheque(Long livreId, Long bibliothequeId) {
        return livreServiceProxy.getOuvrageDispoInOneBibliotheque(livreId,bibliothequeId);
    }

    /**
     * Cherche le nombre d'exemplaires disponibles d'un ouvrage par bibliothèque autre que la bibliothèque selectionnée par l'utilisateur
     * @param livreId l'identifiant du livre correspondant à l'ouvrage
     * @param bibliothequeId l'identifiant de la bibliothèque selectionné par l'utilisateur et non concernée par la recherche
     * @return le nombre d'exemplaire dans chaque bibliothèque, l'identifiant de la bibliothèque et son nom
     */
    @Override
    public List<Object> getOuvrageDispoInOtherBibliotheque(Long livreId, Long bibliothequeId) {
        return livreServiceProxy.getOuvrageDispoInOtherBibliotheque(livreId, bibliothequeId);
    }

    /**
     * Cherche un ouvrage par son identifiant
     * @param ouvrageId l'identifiant de l'ouvrage
     * @return l'ouvrage recherché sous forme de modèle pour la vue
     */
    @Override
    public OuvrageResponseModelBean getOuvrageById(Long ouvrageId) {
        OuvrageBean ouvrageBean = livreServiceProxy.getOuvrageById(ouvrageId);
        OuvrageResponseModelBean ouvrageResponseModelBean = new OuvrageResponseModelBean();
        ouvrageResponseModelBean.setId(ouvrageBean.getId());
        ouvrageResponseModelBean.setIdInterne((ouvrageBean.getIdInterne()));
        ouvrageResponseModelBean.setEmprunte(ouvrageBean.isEmprunte());
        Long livreId = livreServiceProxy.getLivreIdByOuvrageId(ouvrageBean.getId());
        LivreBean livreBean = livreServiceProxy.getLivreById(livreId);
        ouvrageResponseModelBean.setTitre(livreBean.getTitre());
        ouvrageResponseModelBean.setAuteur(livreService.formatListeAuteurs(livreBean.getAuteurs()));
        ouvrageResponseModelBean.setBibliothequeId(ouvrageBean.getBibliothequeId());
        return ouvrageResponseModelBean;
    }

    /**
     * Cherche une liste d'ouvrage en fonction de l'identifiant interne renseigné
     * @param idInterne l'identifiant interne (complet ou partiel)
     * @return la liste des ouvrages correspondants
     */
    @Override
    public List<OuvrageResponseModelBean> getOuvragesByIdInterne(String idInterne) {
        List<OuvrageBean> ouvrageBeans = livreServiceProxy.getOuvragesByIdInterne(idInterne);
        List<OuvrageResponseModelBean> ouvrageResponseModelBeans = new ArrayList<>();
        for (OuvrageBean ouvrageBean : ouvrageBeans) {
            OuvrageResponseModelBean ouvrageResponseModelBean = new OuvrageResponseModelBean();
            ouvrageResponseModelBean.setId(ouvrageBean.getId());
            ouvrageResponseModelBean.setIdInterne((ouvrageBean.getIdInterne()));
            ouvrageResponseModelBean.setEmprunte(ouvrageBean.isEmprunte());
            Long livreId = livreServiceProxy.getLivreIdByOuvrageId(ouvrageBean.getId());
            LivreBean livreBean = livreServiceProxy.getLivreById(livreId);
            ouvrageResponseModelBean.setTitre(livreBean.getTitre());
            ouvrageResponseModelBean.setAuteur(livreService.formatListeAuteurs(livreBean.getAuteurs()));
            ouvrageResponseModelBean.setBibliothequeId(ouvrageBean.getBibliothequeId());
            ouvrageResponseModelBeans.add(ouvrageResponseModelBean);
        }
        return ouvrageResponseModelBeans;
    }

    /**
     * Cherche un ouvrage par son identifiant interne
     * @param idInterne l'identifiant interne de l'ouvrage
     * @return l'ouvrage recherché
     */
    @Override
    public OuvrageResponseModelBean getOuvrageByIdInterne(String idInterne) {
        OuvrageBean ouvrageBean = livreServiceProxy.getOuvrageByIdInterne(idInterne);
        OuvrageResponseModelBean ouvrageResponseModelBean = new OuvrageResponseModelBean();
        ouvrageResponseModelBean.setId(ouvrageBean.getId());
        ouvrageResponseModelBean.setIdInterne((ouvrageBean.getIdInterne()));
        ouvrageResponseModelBean.setEmprunte(ouvrageBean.isEmprunte());
        Long livreId = livreServiceProxy.getLivreIdByOuvrageId(ouvrageBean.getId());
        LivreBean livreBean = livreServiceProxy.getLivreById(livreId);
        ouvrageResponseModelBean.setTitre(livreBean.getTitre());
        ouvrageResponseModelBean.setAuteur(livreService.formatListeAuteurs(livreBean.getAuteurs()));
        ouvrageResponseModelBean.setBibliothequeId(ouvrageBean.getBibliothequeId());
        return ouvrageResponseModelBean;
    }

    @Override
    public CreateEmpruntBean createEmpruntForm(UtilisateurBean utilisateurBean, OuvrageResponseModelBean ouvrageResponseModelBean) {
        CreateEmpruntBean createEmpruntBean = new CreateEmpruntBean();
        createEmpruntBean.setAbonneId(utilisateurBean.getId());
        createEmpruntBean.setNumAbonne(utilisateurBean.getNumAbonne());
        createEmpruntBean.setPrenom(utilisateurBean.getPrenom());
        createEmpruntBean.setNom(utilisateurBean.getNom());
        createEmpruntBean.setNumTelephone(utilisateurBean.getNumTelephone());
        createEmpruntBean.setOuvrageId(ouvrageResponseModelBean.getId());
        createEmpruntBean.setIdInterne(ouvrageResponseModelBean.getIdInterne());
        createEmpruntBean.setTitre(ouvrageResponseModelBean.getTitre());
        createEmpruntBean.setAuteur(ouvrageResponseModelBean.getAuteur());
        return createEmpruntBean;
    }
}
