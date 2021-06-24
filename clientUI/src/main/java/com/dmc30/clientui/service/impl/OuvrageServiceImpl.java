package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.shared.bean.bibliotheque.CreateEmpruntBean;
import com.dmc30.clientui.proxy.LivreServiceProxy;
import com.dmc30.clientui.service.contract.LivreService;
import com.dmc30.clientui.service.contract.OuvrageService;
import com.dmc30.clientui.shared.bean.bibliotheque.OuvrageBean;
import com.dmc30.clientui.shared.bean.bibliotheque.OuvrageResponseModelBean;
import com.dmc30.clientui.shared.bean.livre.LivreBean;
import com.dmc30.clientui.shared.bean.utilisateur.UtilisateurBean;
import com.dmc30.clientui.web.exception.ErrorMessage;
import com.dmc30.clientui.web.exception.TechnicalException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
     *
     * @param livreId        l'identifiant du livre correspondant à l'ouvrage recherché
     * @param bibliothequeId l'identifiant de la bibliothèque selectionnée
     * @return le nombre d'exemplaire de l'ouvrage
     */
    @Override
    public Integer getOuvrageDispoInOneBibliotheque(Long livreId, Long bibliothequeId) throws TechnicalException {
        int ouvragesDispos;
        try {
            ouvragesDispos = livreServiceProxy.getOuvrageDispoInOneBibliotheque(livreId, bibliothequeId);
        } catch (FeignException e) {
            throw new TechnicalException(ErrorMessage.TECHNICAL_ERROR.getErrorMessage());
        }
        return ouvragesDispos;
    }

    /**
     * Cherche le nombre d'exemplaires disponibles d'un ouvrage par bibliothèque autre que la bibliothèque selectionnée par l'utilisateur
     *
     * @param livreId        l'identifiant du livre correspondant à l'ouvrage
     * @param bibliothequeId l'identifiant de la bibliothèque selectionné par l'utilisateur et non concernée par la recherche
     * @return le nombre d'exemplaire dans chaque bibliothèque, l'identifiant de la bibliothèque et son nom
     */
    @Override
    public List<Object> getOuvrageDispoInOtherBibliotheque(Long livreId, Long bibliothequeId) throws TechnicalException {
        List<Object> ouvragesDispos = new ArrayList<>();
        try {
            ouvragesDispos = livreServiceProxy.getOuvrageDispoInOtherBibliotheque(livreId, bibliothequeId);
        } catch (FeignException e) {
            throw new TechnicalException(ErrorMessage.TECHNICAL_ERROR.getErrorMessage());
        }
        return ouvragesDispos;
    }

    /**
     * Cherche un ouvrage par son identifiant
     *
     * @param ouvrageId l'identifiant de l'ouvrage
     * @return l'ouvrage recherché sous forme de modèle pour la vue
     */
    @Override
    public OuvrageResponseModelBean getOuvrageById(Long ouvrageId) throws TechnicalException {
        OuvrageResponseModelBean ouvrageResponseModelBean = new OuvrageResponseModelBean();
        OuvrageBean ouvrageBean = new OuvrageBean();
        try {
            ouvrageBean = livreServiceProxy.getOuvrageById(ouvrageId);
            ouvrageResponseModelBean.setId(ouvrageBean.getId());
            ouvrageResponseModelBean.setIdInterne((ouvrageBean.getIdInterne()));
            ouvrageResponseModelBean.setEmprunte(ouvrageBean.isEmprunte());
            Long livreId = livreServiceProxy.getLivreIdByOuvrageId(ouvrageBean.getId());
            ResponseEntity<?> response = livreServiceProxy.getLivreById(livreId);
            ObjectMapper mapper = new ObjectMapper();
            LivreBean livreBean = mapper.convertValue(response.getBody(), LivreBean.class);
            ouvrageResponseModelBean.setTitre(livreBean.getTitre());
            ouvrageResponseModelBean.setAuteur(livreService.formatListeAuteurs(livreBean.getAuteurs()));
            ouvrageResponseModelBean.setBibliothequeId(ouvrageBean.getBibliothequeId());
        } catch (FeignException e) {
            throw new TechnicalException(ErrorMessage.TECHNICAL_ERROR.getErrorMessage());
        }
        return ouvrageResponseModelBean;
    }

    /**
     * Cherche une liste d'ouvrage en fonction de l'identifiant interne renseigné
     *
     * @param idInterne l'identifiant interne (complet ou partiel)
     * @return la liste des ouvrages correspondants
     */
    @Override
    public List<OuvrageResponseModelBean> getOuvragesByIdInterne(String idInterne) throws TechnicalException {
        List<OuvrageBean> ouvrageBeans = new ArrayList<>();
        List<OuvrageResponseModelBean> ouvrageResponseModelBeans = new ArrayList<>();
        try {
            ouvrageBeans = livreServiceProxy.getOuvragesByIdInterne(idInterne);
            for (OuvrageBean ouvrageBean : ouvrageBeans) {
                OuvrageResponseModelBean ouvrageResponseModelBean = new OuvrageResponseModelBean();
                ouvrageResponseModelBean.setId(ouvrageBean.getId());
                ouvrageResponseModelBean.setIdInterne((ouvrageBean.getIdInterne()));
                ouvrageResponseModelBean.setEmprunte(ouvrageBean.isEmprunte());
                Long livreId = livreServiceProxy.getLivreIdByOuvrageId(ouvrageBean.getId());
                ResponseEntity<?> response = livreServiceProxy.getLivreById(livreId);
                ObjectMapper mapper = new ObjectMapper();
                LivreBean livreBean = mapper.convertValue(response.getBody(), LivreBean.class);
                ouvrageResponseModelBean.setTitre(livreBean.getTitre());
                ouvrageResponseModelBean.setAuteur(livreService.formatListeAuteurs(livreBean.getAuteurs()));
                ouvrageResponseModelBean.setBibliothequeId(ouvrageBean.getBibliothequeId());
                ouvrageResponseModelBeans.add(ouvrageResponseModelBean);
            }
        }catch (FeignException e) {
            throw new TechnicalException(ErrorMessage.TECHNICAL_ERROR.getErrorMessage());
        }
            return ouvrageResponseModelBeans;
        }

        /**
         * Cherche un ouvrage par son identifiant interne
         *
         * @param idInterne l'identifiant interne de l'ouvrage
         * @return l'ouvrage recherché
         */
        @Override
        public OuvrageResponseModelBean getOuvrageByIdInterne (String idInterne) throws TechnicalException {
            OuvrageBean ouvrageBean = new OuvrageBean();
            OuvrageResponseModelBean ouvrageResponseModelBean = new OuvrageResponseModelBean();
            try {
                ouvrageBean = livreServiceProxy.getOuvrageByIdInterne(idInterne);

                ouvrageResponseModelBean.setId(ouvrageBean.getId());
                ouvrageResponseModelBean.setIdInterne((ouvrageBean.getIdInterne()));
                ouvrageResponseModelBean.setEmprunte(ouvrageBean.isEmprunte());
                Long livreId = livreServiceProxy.getLivreIdByOuvrageId(ouvrageBean.getId());
                ResponseEntity<?> response = livreServiceProxy.getLivreById(livreId);
                ObjectMapper mapper = new ObjectMapper();
                LivreBean livreBean = mapper.convertValue(response.getBody(), LivreBean.class);
                ouvrageResponseModelBean.setTitre(livreBean.getTitre());
                ouvrageResponseModelBean.setAuteur(livreService.formatListeAuteurs(livreBean.getAuteurs()));
                ouvrageResponseModelBean.setBibliothequeId(ouvrageBean.getBibliothequeId());
            } catch (FeignException e) {
                throw new TechnicalException(ErrorMessage.TECHNICAL_ERROR.getErrorMessage());
            }
            return ouvrageResponseModelBean;
        }
    }
