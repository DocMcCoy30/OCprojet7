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

    @GetMapping("/check")
    public String checkStatus () {
        return "User_Api ' s working";
    }

    @GetMapping("/abonne")
    public UtilisateurDto findAbonneByPublicId(@RequestParam String publicId) {
        UtilisateurDto abonne = usersService.getUtilisateurByPublicId(publicId);
        return abonne;
    }

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
