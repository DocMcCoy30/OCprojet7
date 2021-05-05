package com.dmc30.userapi.service;

import com.dmc30.userapi.model.bean.UserDetails;
import com.dmc30.userapi.model.entity.Abonne;
import com.dmc30.userapi.model.entity.Employe;

import java.util.List;

public interface UserService {

    List<Abonne> findAllAbonne();
    Abonne findAbonneById(int abonneId);
    void createAbonne(Abonne abonne, int paysId);
    void deleteAbonne(Abonne abonne);


    List<Employe> findAllEmploye();
    Employe findEmployeById(int employeId);
    void createEmploye(Employe employe);
    void deleteEmploye(Employe employe);

    String authenticateUser (UserDetails userDetails);





}
