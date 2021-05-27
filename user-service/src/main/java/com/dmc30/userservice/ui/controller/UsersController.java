package com.dmc30.userservice.ui.controller;

import com.dmc30.userservice.service.contract.UsersService;
import com.dmc30.userservice.shared.UtilisateurDto;
import com.dmc30.userservice.ui.model.CreateAbonneResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Recherche d'un utilisateur par son identifiant public (UUID)
     * @param publicId l'identifiant de l'utilisateur
     * @return l'utilisateur recherché
     */
    @GetMapping("/utilisateur")
    public UtilisateurDto findUtilisateurByPublicId(@RequestParam String publicId) {
        UtilisateurDto abonne = usersService.getUtilisateurByPublicId(publicId);
        return abonne;
    }

    /**
     * Création d'un nouvel utilisateur dans la BD
     * @param utilisateurDto Les caractéristiques de l'utilisateur entrées dans la vue
     * @param paysId L'identifiant du pays de résidence choisi
     * @return Response entity : le statut + les données utiles pour la réponse à retourner au client (Response Model)
     */
    @PostMapping("/signin")
    public ResponseEntity<CreateAbonneResponseModel> createAbonne(@RequestBody UtilisateurDto utilisateurDto,
                                                                  @RequestParam Long paysId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        logger.info(utilisateurDto.toString());
        UtilisateurDto createdAbonne = usersService.createAbonne(utilisateurDto, paysId);
        CreateAbonneResponseModel returnValue = modelMapper.map(createdAbonne, CreateAbonneResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }
}
