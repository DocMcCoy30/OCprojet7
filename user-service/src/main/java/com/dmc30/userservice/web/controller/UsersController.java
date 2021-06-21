package com.dmc30.userservice.web.controller;

import com.dmc30.userservice.service.contract.UsersService;
import com.dmc30.userservice.service.dto.UtilisateurDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    Logger logger = LoggerFactory.getLogger(UsersController.class);

    UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    /**
     * Methode de test connexion du service
     * @return un message de confirmation
     */
    @GetMapping("/check")
    public String checkStatus () {
        return "User_Api ' s working";
    }

    @GetMapping("/id")
    UtilisateurDto findUtilisateurById(@RequestParam Long utilisateurId) {
                return usersService.getUtilisateurById(utilisateurId);
    }

    @GetMapping("/all")
    List<UtilisateurDto> findAll() {
        return usersService.getAll();
    }


    /**
     * Recherche d'un utilisateur par son identifiant public (UUID)
     * @param publicId l'identifiant de l'utilisateur
     * @return l'utilisateur recherché
     */
    @GetMapping("/publicId")
    public UtilisateurDto findUtilisateurByPublicId(@RequestParam String publicId) {
        UtilisateurDto abonne = usersService.getUtilisateurByPublicId(publicId);
        return abonne;
    }

    /**
     * Recherche d'un utilisateur par son username
     * @param username le username de l'utilisateur
     * @return l'utilisateur recherché
     */
    @GetMapping("/username")
    public UtilisateurDto findUtilisateurByUsername(@RequestParam String username) {
        UtilisateurDto abonne = usersService.GetUtilisateurByUsername(username);
        return abonne;
    }

    @GetMapping("/numAb")
    public UtilisateurDto getUtilisateurByNumAbonne(@RequestParam String numAbonne) {
        return usersService.getUtilisateurByNumAbonne(numAbonne);
    }

    /**
     * Recherche d'une liste d'utilisateurs par un numero d'abonné (partiel)
     * @param numAbonne le numero d'abonné partiel renseigné dans la vue
     * @return la liste d'utilisateurs recherchés
     */
    @GetMapping("/utilisateurs")
    public List<UtilisateurDto> findUtilisateursByNumAbonne(@RequestParam String numAbonne) {
        List<UtilisateurDto> abonnes = usersService.getUtilisateursByNumAbonne(numAbonne);
        return abonnes;
    }

    /**
     * Création d'un nouvel utilisateur dans la BD
     * @param utilisateurDto Les caractéristiques de l'utilisateur entrées dans la vue
     * @param paysId L'identifiant du pays de résidence choisi
     * @return Response entity : le statut + les données utiles pour la réponse à retourner au client (Response Model)
     */
    @PostMapping("/signin")
    public UtilisateurDto createAbonne(@RequestBody UtilisateurDto utilisateurDto,
                                                                  @RequestParam Long paysId) {
        UtilisateurDto createdAbonne = usersService.createAbonne(utilisateurDto, paysId);
        return createdAbonne;
    }

    /**
     * Modifie le profil d'un utilisateur
     * @param utilisateurDto l'utilisateur concerné
     */
    @PostMapping("/update")
    public void updateUtilisateur(@RequestBody UtilisateurDto utilisateurDto) {
        usersService.updateUtilisateur(utilisateurDto);
    }
}
