package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.proxy.LivreServiceProxy;
import com.dmc30.clientui.service.contract.LivreService;
import com.dmc30.clientui.shared.bean.livre.AuteurBean;
import com.dmc30.clientui.shared.bean.livre.GenreBean;
import com.dmc30.clientui.shared.bean.livre.LivreBean;
import com.dmc30.clientui.shared.bean.livre.LivreResponseModelBean;
import com.dmc30.clientui.web.exception.ErrorMessage;
import com.dmc30.clientui.web.exception.TechnicalException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivreServiceImpl implements LivreService {

    Logger logger = LoggerFactory.getLogger(LivreServiceImpl.class);

    LivreServiceProxy livreServiceProxy;

    @Autowired
    public LivreServiceImpl(LivreServiceProxy livreServiceProxy) {
        this.livreServiceProxy = livreServiceProxy;
    }

    /**
     * Cherche la liste de tous les livres enregistrés dans la base de données
     *
     * @return la liste de tous les livres
     */
    @Override
    public List<LivreResponseModelBean> getLivres() throws TechnicalException {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<LivreResponseModelBean> livreResponseModelBeanList = new ArrayList<>();
        try {
            List<LivreBean> livreBeans = livreServiceProxy.getLivres();
            for (LivreBean livre : livreBeans) {
                LivreResponseModelBean livreResponseModelBean = modelMapper.map(livre, LivreResponseModelBean.class);
                livreResponseModelBean.setAuteurs(formatListeAuteurs(livre.getAuteurs()));
                livreResponseModelBean.setGenres(formatListeGenres(livre.getGenres()));
                livreResponseModelBeanList.add(livreResponseModelBean);
            }
        }catch (FeignException e) {
            throw new TechnicalException(ErrorMessage.TECHNICAL_ERROR.getErrorMessage());
        }
        return livreResponseModelBeanList;
    }

    /**
     * Renvoie la liste des 12 derniers livres enregistrés dans la BD au controller
     *
     * @return la liste des 12 derniers livres
     */
    @Override
    public List<LivreResponseModelBean> get12LastLivres() throws TechnicalException {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<LivreResponseModelBean> livreResponseModelBeanList = new ArrayList<>();
        try {
            List<LivreBean> livreBeans = livreServiceProxy.get12LastLivres();
            for (LivreBean livre : livreBeans) {
                LivreResponseModelBean livreResponseModelBean = modelMapper.map(livre, LivreResponseModelBean.class);
                livreResponseModelBean.setAuteurs(formatListeAuteurs(livre.getAuteurs()));
                livreResponseModelBean.setGenres(formatListeGenres(livre.getGenres()));
                livreResponseModelBeanList.add(livreResponseModelBean);
            }
        } catch (FeignException e) {
            throw new TechnicalException(ErrorMessage.TECHNICAL_ERROR.getErrorMessage());
        }
        return livreResponseModelBeanList;
    }

    /**
     * Cherche un livre par son identifiant et le renvoie au controller
     *
     * @param livreId l'identifiant du livre
     * @return le livre recherché
     */
    @Override
    public ResponseEntity<?> getLivreById(Long livreId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        try {
            ResponseEntity<?> response = livreServiceProxy.getLivreById(livreId);
            ObjectMapper mapper = new ObjectMapper();
            LivreBean livreBean = mapper.convertValue(response.getBody(), LivreBean.class);
            LivreResponseModelBean livreResponseModelBean = modelMapper.map(livreBean, LivreResponseModelBean.class);
            livreResponseModelBean.setAuteurs(formatListeAuteurs(livreBean.getAuteurs()));
            livreResponseModelBean.setGenres(formatListeGenres(livreBean.getGenres()));
            return ResponseEntity.status(response.getStatusCodeValue()).body(livreResponseModelBean);
        } catch (FeignException e) {
            int status = e.status();
            String message = e.getMessage();
            logger.info("StatusCode = " + status + " - Message = " + message);
            ResponseEntity<?> responseEntity = ResponseEntity.status(ErrorMessage.INTROUVABLE_EXCEPTION.getErrorCode())
                    .body(ErrorMessage.INTROUVABLE_EXCEPTION.getErrorMessage());
            return responseEntity;
        }
    }

    /**
     * Cherche les livres dont le titre contient le mot clé entré par l'utilisateur
     *
     * @param motCle le mot-clé critère de recherche
     * @return la liste des livres correcpondants au critère de recherche
     */
    @Override
    public List<LivreResponseModelBean> getLivreByTitre(String motCle) throws TechnicalException {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<LivreResponseModelBean> livreResponseModelBeanList = new ArrayList<>();
        try {
            List<LivreBean> livreBeans = livreServiceProxy.getLivreByTitre(motCle);
            for (LivreBean livre : livreBeans) {
                LivreResponseModelBean livreResponseModelBean = modelMapper.map(livre, LivreResponseModelBean.class);
                livreResponseModelBean.setAuteurs(formatListeAuteurs(livre.getAuteurs()));
                livreResponseModelBean.setGenres(formatListeGenres(livre.getGenres()));
                livreResponseModelBeanList.add(livreResponseModelBean);
            }
        } catch (FeignException e) {
            throw new TechnicalException(ErrorMessage.TECHNICAL_ERROR.getErrorMessage());
        }
        return livreResponseModelBeanList;
    }

    /**
     * Cherche les livres pour un auteur
     *
     * @param auteurId l'identifiant de l'auteur
     * @return la liste des livres recherchés
     */
    @Override
    public List<LivreResponseModelBean> getLivreByAuteur(Long auteurId) throws TechnicalException {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<LivreResponseModelBean> livreResponseModelBeanList = new ArrayList<>();
        try {
            List<LivreBean> livreBeans = livreServiceProxy.getLivreByAuteur(auteurId);
            for (LivreBean livre : livreBeans) {
                LivreResponseModelBean livreResponseModelBean = modelMapper.map(livre, LivreResponseModelBean.class);
                livreResponseModelBean.setAuteurs(formatListeAuteurs(livre.getAuteurs()));
                livreResponseModelBean.setGenres(formatListeGenres(livre.getGenres()));
                livreResponseModelBeanList.add(livreResponseModelBean);
            }
        } catch (FeignException e) {
            throw new TechnicalException(ErrorMessage.TECHNICAL_ERROR.getErrorMessage());
        }
        return livreResponseModelBeanList;
    }

    /**
     * Formate la liste des auteurs d'un livre pour le renvoyer à la vue
     *
     * @param auteurs la liste des auteurs d'un livre à transformer en suite de caractères
     * @return la String formatée des auteurs pour la vue
     */
    @Override
    public String formatListeAuteurs(List<AuteurBean> auteurs) {
        List<String> nomDesAuteurs = new ArrayList<>();
        String prenom = "";
        String nom = "";
        String auteursPourVue = "";
        for (AuteurBean auteur : auteurs) {
            if (auteur.getPrenom() != null) {
                prenom = auteur.getPrenom();
            }
            if (auteur.getNom() != null) {
                nom = auteur.getNom();
            }
            String prenomNom = prenom + " " + nom + " ";
            nomDesAuteurs.add(prenomNom);
            nomDesAuteurs.add(" - ");
        }
        if (nomDesAuteurs.size() > 0)
            nomDesAuteurs.remove(nomDesAuteurs.size() - 1);
        auteursPourVue = StringUtils.join(nomDesAuteurs, "");
        return auteursPourVue;
    }

    /**
     * Formate la liste des genres d'un livre pour le renvoyer à la vue
     *
     * @param genres la liste des genres d'un livre à transformer en suite de caractères
     * @return la String formatée des genres pour la vue
     */
    @Override
    public String formatListeGenres(List<GenreBean> genres) {
        List<String> nomDesGenres = new ArrayList<>();
        String genrePourVue = "";
        for (GenreBean genre : genres) {
            String nomDuGenre = genre.getGenre();
            nomDesGenres.add(nomDuGenre);
            nomDesGenres.add(" - ");
        }
        if (nomDesGenres.size() > 0) {
            nomDesGenres.remove(nomDesGenres.size() - 1);
            genrePourVue = StringUtils.join(nomDesGenres, "");
        }
        return genrePourVue;
    }
}

