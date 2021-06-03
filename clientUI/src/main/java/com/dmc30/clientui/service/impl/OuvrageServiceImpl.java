package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.proxy.LivreServiceProxy;
import com.dmc30.clientui.service.contract.LivreService;
import com.dmc30.clientui.service.contract.OuvrageService;
import com.dmc30.clientui.shared.bibliotheque.CreateEmpruntDto;
import com.dmc30.clientui.shared.bibliotheque.OuvrageDto;
import com.dmc30.clientui.shared.bibliotheque.OuvrageResponseModelDto;
import com.dmc30.clientui.shared.livre.LivreDto;
import com.dmc30.clientui.shared.utilisateur.UtilisateurDto;
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
    public OuvrageResponseModelDto getOuvrageById(Long ouvrageId) {
        OuvrageDto ouvrageDto = livreServiceProxy.getOuvrageById(ouvrageId);
        OuvrageResponseModelDto ouvrageResponseModelDto = new OuvrageResponseModelDto();
        ouvrageResponseModelDto.setId(ouvrageDto.getId());
        ouvrageResponseModelDto.setIdInterne((ouvrageDto.getIdInterne()));
        Long livreId = livreServiceProxy.getLivreIdByOuvrageId(ouvrageDto.getId());
        LivreDto livreDto = livreServiceProxy.getLivreById(livreId);
        ouvrageResponseModelDto.setTitre(livreDto.getTitre());
        ouvrageResponseModelDto.setAuteur(livreService.formatListeAuteurs(livreDto.getAuteurs()));
        return ouvrageResponseModelDto;
    }

    /**
     * Cherche une liste d'ouvrage en fonction de l'identifiant interne renseigné
     * @param idInterne l'identifiant interne (complet ou partiel)
     * @return la liste des ouvrages correspondants
     */
    @Override
    public List<OuvrageResponseModelDto> getOuvragesByIdInterne(String idInterne) {
        List<OuvrageDto> ouvrageDtos = livreServiceProxy.getOuvragesByIdInterne(idInterne);
        List<OuvrageResponseModelDto> ouvrageResponseModelDtos = new ArrayList<>();
        for (OuvrageDto ouvrageDto:ouvrageDtos) {
            OuvrageResponseModelDto ouvrageResponseModelDto = new OuvrageResponseModelDto();
            ouvrageResponseModelDto.setId(ouvrageDto.getId());
            ouvrageResponseModelDto.setIdInterne((ouvrageDto.getIdInterne()));
            Long livreId = livreServiceProxy.getLivreIdByOuvrageId(ouvrageDto.getId());
            LivreDto livreDto = livreServiceProxy.getLivreById(livreId);
            ouvrageResponseModelDto.setTitre(livreDto.getTitre());
            ouvrageResponseModelDto.setAuteur(livreService.formatListeAuteurs(livreDto.getAuteurs()));
            ouvrageResponseModelDtos.add(ouvrageResponseModelDto);
        }
        return ouvrageResponseModelDtos;
    }

    @Override
    public OuvrageResponseModelDto getOuvrageByIdInterne(String idInterne) {
        OuvrageDto ouvrageDto = livreServiceProxy.getOuvrageByIdInterne(idInterne);
        OuvrageResponseModelDto ouvrageResponseModelDto = new OuvrageResponseModelDto();
        ouvrageResponseModelDto.setId(ouvrageDto.getId());
        ouvrageResponseModelDto.setIdInterne((ouvrageDto.getIdInterne()));
        Long livreId = livreServiceProxy.getLivreIdByOuvrageId(ouvrageDto.getId());
        LivreDto livreDto = livreServiceProxy.getLivreById(livreId);
        ouvrageResponseModelDto.setTitre(livreDto.getTitre());
        ouvrageResponseModelDto.setAuteur(livreService.formatListeAuteurs(livreDto.getAuteurs()));
        return ouvrageResponseModelDto;
    }

    @Override
    public CreateEmpruntDto createEmpruntForm(UtilisateurDto utilisateurDto, OuvrageResponseModelDto ouvrageResponseModelDto) {
        CreateEmpruntDto createEmpruntDto = new CreateEmpruntDto();
        createEmpruntDto.setAbonneId(utilisateurDto.getId());
        createEmpruntDto.setNumAbonne(utilisateurDto.getNumAbonne());
        createEmpruntDto.setPrenom(utilisateurDto.getPrenom());
        createEmpruntDto.setNom(utilisateurDto.getNom());
        createEmpruntDto.setNumTelephone(utilisateurDto.getNumTelephone());
        createEmpruntDto.setOuvrageId(ouvrageResponseModelDto.getId());
        createEmpruntDto.setIdInterne(ouvrageResponseModelDto.getIdInterne());
        createEmpruntDto.setTitre(ouvrageResponseModelDto.getTitre());
        createEmpruntDto.setAuteur(ouvrageResponseModelDto.getAuteur());
        return createEmpruntDto;
    }
}
