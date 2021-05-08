package com.dmc30.userapi.ui.controller;

import com.dmc30.userapi.shared.UsersDto;
import com.dmc30.userapi.service.contract.UsersService;
import com.dmc30.userapi.ui.model.CreateAbonneRequestModel;
import com.dmc30.userapi.ui.model.CreateAbonneResponseModel;
import com.dmc30.userapi.ui.model.CreateEmployeRequestModel;
import com.dmc30.userapi.ui.model.CreateEmployeResponseModel;
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

//    @PostMapping("/signin")
//    public ResponseEntity<CreateAbonneResponseModel> createAbonne(@RequestBody CreateAbonneRequestModel userDetails,
//                                                                  @RequestParam Long paysId) {
//        logger.info(userDetails.toString());
//        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        UsersDto abonne = modelMapper.map(userDetails, UsersDto.class);
//        UsersDto createdAbonne = usersService.createAbonne(abonne, paysId);
//        CreateAbonneResponseModel returnValue = modelMapper.map(createdAbonne, CreateAbonneResponseModel.class);
//        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
//    }

    @PostMapping("/signin")
    public ResponseEntity<CreateAbonneResponseModel> createAbonne(@RequestBody UsersDto usersDto,
                                                                  @RequestParam Long paysId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        logger.info(usersDto.toString());
        UsersDto createdAbonne = usersService.createAbonne(usersDto, paysId);
        CreateAbonneResponseModel returnValue = modelMapper.map(createdAbonne, CreateAbonneResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }

    @PostMapping("/employe")
    public ResponseEntity<CreateEmployeResponseModel> createEmploye(@RequestBody CreateEmployeRequestModel userDetails) {
        logger.info(userDetails.toString());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UsersDto employe = modelMapper.map(userDetails, UsersDto.class);
        UsersDto createdEmploye = usersService.createEmploye(employe);
        CreateEmployeResponseModel returnValue = modelMapper.map(createdEmploye, CreateEmployeResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }
}
