package com.dmc30.userapi.service.contract;

import com.dmc30.userapi.exception.TechnicalException;
import com.dmc30.userapi.model.dto.UserDetailsDto;
import com.dmc30.userapi.model.entity.Abonne;
import com.dmc30.userapi.model.entity.Employe;

import java.util.List;

public interface UserService {

    List<Abonne> findAllAbonne() throws TechnicalException;
    Abonne findAbonneById(int abonneId) throws TechnicalException;
    void createAbonne(Abonne abonne, int paysId) throws TechnicalException;
    void deleteAbonne(Abonne abonne);


    List<Employe> findAllEmploye() throws TechnicalException;
    Employe findEmployeById(int employeId) throws TechnicalException;
    void createEmploye(Employe employe);
    void deleteEmploye(Employe employe);

    String authenticateUser (UserDetailsDto userDetailsDto);





}
