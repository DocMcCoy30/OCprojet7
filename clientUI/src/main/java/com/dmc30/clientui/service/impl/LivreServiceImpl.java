package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.bean.livre.AuteurBean;
import com.dmc30.clientui.bean.livre.LivreBean;
import com.dmc30.clientui.proxy.LivreServiceProxy;
import com.dmc30.clientui.service.contract.LivreService;
import com.dmc30.clientui.bean.livre.LivreResponseModelBean;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivreServiceImpl implements LivreService {

    LivreServiceProxy livreServiceProxy;

    @Autowired
    public LivreServiceImpl(LivreServiceProxy livreServiceProxy) {
        this.livreServiceProxy = livreServiceProxy;
    }

    /**
     * Cherche la liste de tous les livres enregistrés dans la base de données
     * @return la liste de tous les livres
     */
    @Override
    public List<LivreResponseModelBean> getLivres() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<LivreResponseModelBean> livreResponseModelBeanList = new ArrayList<>();
        List<LivreBean> livreBeans = livreServiceProxy.getLivres();
        for (LivreBean livre: livreBeans) {
            LivreResponseModelBean livreResponseModelBean = modelMapper.map(livre, LivreResponseModelBean.class);
            livreResponseModelBean.setAuteurs(formatListeAuteurs(livre.getAuteurs()));
            livreResponseModelBeanList.add(livreResponseModelBean);
        }
        return livreResponseModelBeanList;
    }

    /**
     * Renvoie la liste des 12 derniers livres enregistrés dans la BD au controller
     * @return la liste des 12 derniers livres
     */
    @Override
    public List<LivreResponseModelBean> get12LastLivres() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<LivreResponseModelBean> livreResponseModelBeanList = new ArrayList<>();
        List<LivreBean> livreBeans = livreServiceProxy.get12LastLivres();
        for (LivreBean livre: livreBeans) {
            LivreResponseModelBean livreResponseModelBean = modelMapper.map(livre, LivreResponseModelBean.class);
            livreResponseModelBean.setAuteurs(formatListeAuteurs(livre.getAuteurs()));
            livreResponseModelBeanList.add(livreResponseModelBean);
        }
        return livreResponseModelBeanList;
    }

    /**
     * Cherche un livre par son identifiant et le renvoie au controller
     * @param livreId l'identifiant du livre
     * @return le livre recherché
     */
    @Override
    public LivreResponseModelBean getLivreById(Long livreId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        LivreBean livreBean = livreServiceProxy.getLivreById(livreId);
        LivreResponseModelBean livreResponseModelBean = modelMapper.map(livreBean, LivreResponseModelBean.class);
        livreResponseModelBean.setAuteurs(formatListeAuteurs(livreBean.getAuteurs()));
        return livreResponseModelBean;
    }

    /**
     * Cherche les livres dont le titre contient le mot clé entré par l'utilisateur
     * @param motCle le mot-clé critère de recherche
     * @return la liste des livres correcpondants au critère de recherche
     */
    @Override
    public List<LivreResponseModelBean> getLivreByTitre(String motCle) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<LivreResponseModelBean> livreResponseModelBeanList = new ArrayList<>();
        List<LivreBean> livreBeans = livreServiceProxy.getLivreByTitre(motCle);
        for (LivreBean livre: livreBeans) {
            LivreResponseModelBean livreResponseModelBean = modelMapper.map(livre, LivreResponseModelBean.class);
            livreResponseModelBean.setAuteurs(formatListeAuteurs(livre.getAuteurs()));
            livreResponseModelBeanList.add(livreResponseModelBean);
        }
        return livreResponseModelBeanList;
    }

    /**
     * Cherche les livres pour un auteur
     * @param auteurId l'identifiant de l'auteur
     * @return la liste des livres recherchés
     */
    @Override
    public List<LivreResponseModelBean> getLivreByAuteur(Long auteurId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<LivreResponseModelBean> livreResponseModelBeanList = new ArrayList<>();
        List<LivreBean> livreBeans = livreServiceProxy.getLivreByAuteur(auteurId);
        for (LivreBean livre: livreBeans) {
            LivreResponseModelBean livreResponseModelBean = modelMapper.map(livre, LivreResponseModelBean.class);
            livreResponseModelBean.setAuteurs(formatListeAuteurs(livre.getAuteurs()));
            livreResponseModelBeanList.add(livreResponseModelBean);
        }
        return livreResponseModelBeanList;
    }

    /**
     * Formate la liste des auteurs d'un livre pour le renvoyer à la vue
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
}

