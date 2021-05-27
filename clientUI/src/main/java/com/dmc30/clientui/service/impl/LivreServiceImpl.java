package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.shared.bibliotheque.BibliothequeDto;
import com.dmc30.clientui.shared.livre.AuteurDto;
import com.dmc30.clientui.shared.livre.LivreDto;
import com.dmc30.clientui.proxy.LivreServiceProxy;
import com.dmc30.clientui.service.contract.LivreService;
import com.dmc30.clientui.ui.model.LivreResponseModel;
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
    public List<LivreResponseModel> getLivres() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<LivreResponseModel> livreResponseModelList = new ArrayList<>();
        List<LivreDto> livreDtos = livreServiceProxy.getLivres();
        for (LivreDto livre:livreDtos) {
            LivreResponseModel livreResponseModel = modelMapper.map(livre, LivreResponseModel.class);
            livreResponseModel.setAuteurs(formatListeAuteurs(livre.getAuteurs()));
            livreResponseModelList.add(livreResponseModel);
        }
        return livreResponseModelList;
    }

    /**
     * Renvoie la liste des 12 derniers livres enregistrés dans la BD au controller
     * @return la liste des 12 derniers livres
     */
    @Override
    public List<LivreResponseModel> get12LastLivres() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<LivreResponseModel> livreResponseModelList = new ArrayList<>();
        List<LivreDto> livreDtos = livreServiceProxy.get12LastLivres();
        for (LivreDto livre:livreDtos) {
            LivreResponseModel livreResponseModel = modelMapper.map(livre, LivreResponseModel.class);
            livreResponseModel.setAuteurs(formatListeAuteurs(livre.getAuteurs()));
            livreResponseModelList.add(livreResponseModel);
        }
        return livreResponseModelList;
    }

    /**
     * Cherche un livre par son identifiant et le renvoie au controller
     * @param livreId l'identifiant du livre
     * @return le livre recherché
     */
    @Override
    public LivreResponseModel getLivreById(Long livreId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        LivreDto livreDto = livreServiceProxy.getLivreById(livreId);
        LivreResponseModel livreResponseModel = modelMapper.map(livreDto, LivreResponseModel.class);
        livreResponseModel.setAuteurs(formatListeAuteurs(livreDto.getAuteurs()));
        return livreResponseModel;
    }

    /**
     * Cherche les livres dont le titre contient le mot clé entré par l'utilisateur
     * @param motCle le mot-clé critère de recherche
     * @return la liste des livres correcpondants au critère de recherche
     */
    @Override
    public List<LivreResponseModel> getLivreByTitre(String motCle) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<LivreResponseModel> livreResponseModelList = new ArrayList<>();
        List<LivreDto> livreDtos = livreServiceProxy.getLivreByTitre(motCle);
        for (LivreDto livre:livreDtos) {
            LivreResponseModel livreResponseModel = modelMapper.map(livre, LivreResponseModel.class);
            livreResponseModel.setAuteurs(formatListeAuteurs(livre.getAuteurs()));
            livreResponseModelList.add(livreResponseModel);
        }
        return livreResponseModelList;
    }

    /**
     * Cherche les livres dont l'auteur contient le mot clé renseigné par l'utilisateur
     * @param motCle le mot clé 4, critère de recherche
     * @return la liste des livres recherchés
     */
    @Override
    public List<LivreResponseModel> getLivreByAuteur(String motCle) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<LivreResponseModel> livreResponseModelList = new ArrayList<>();
        List<LivreDto> livreDtos = livreServiceProxy.getLivreByAuteur(motCle);
        for (LivreDto livre:livreDtos) {
            LivreResponseModel livreResponseModel = modelMapper.map(livre, LivreResponseModel.class);
            livreResponseModel.setAuteurs(formatListeAuteurs(livre.getAuteurs()));
            livreResponseModelList.add(livreResponseModel);
        }
        return livreResponseModelList;
    }

    /**
     * Formate la liste des auteurs d'un livre pour le renvoyer à la vue
     * @param auteurs la liste des auteurs d'un livre à transformer en suite de caractères
     * @return la String formatée des auteurs pour la vue
     */
    @Override
    public String formatListeAuteurs(List<AuteurDto> auteurs) {
        List<String> nomDesAuteurs = new ArrayList<>();
        String prenom = "";
        String nom = "";
        String auteursPourVue = "";
        for (AuteurDto auteur : auteurs) {
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

