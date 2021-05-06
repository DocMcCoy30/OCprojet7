package com.dmc30.userapi.service.impl;

import com.dmc30.userapi.exception.ErrorMessages;
import com.dmc30.userapi.exception.TechnicalException;
import com.dmc30.userapi.model.dto.UserDetailsDto;
import com.dmc30.userapi.model.entity.*;
import com.dmc30.userapi.repository.*;
import com.dmc30.userapi.security.PasswordEncoderHelper;
import com.dmc30.userapi.service.contract.UserService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    AbonneRepository abonneRepository;
    EmployeRepository employeRepository;
    AdresseRepository adresseRepository;
    PaysRepository paysRepository;
    RoleRepository roleRepository;
    PasswordEncoderHelper passwordEncoderHelper;

    public UserServiceImpl(AbonneRepository abonneRepository, EmployeRepository employeRepository, AdresseRepository adresseRepository, PaysRepository paysRepository, RoleRepository roleRepository, PasswordEncoderHelper passwordEncoderHelper) {
        this.abonneRepository = abonneRepository;
        this.employeRepository = employeRepository;
        this.adresseRepository = adresseRepository;
        this.paysRepository = paysRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoderHelper = passwordEncoderHelper;
    }

    @Override
    public List<Abonne> findAllAbonne() throws TechnicalException {
        List<Abonne> abonnes = abonneRepository.findAll();
        if (abonnes == null) {
            throw new TechnicalException("Aucun résultat de recherche");
        } else return abonnes;
    }

    @Override
    public Abonne findAbonneById(int abonneId) throws TechnicalException {
        Optional<Abonne> result = abonneRepository.findById(abonneId);
        Abonne abonne = null;
        if (result.isPresent()) {
            abonne = result.get();
        } else throw new TechnicalException("Abonne non trouvé");
        return abonne;
    }

    @Override
    public void createAbonne(Abonne abonne, int paysId) throws TechnicalException {
        //set Numero Abonne
        abonne.setNumAbonne(UUID.randomUUID().toString());
        //get Adresse de l'abonné
        Adresse adresse = abonne.getAdresse();
        //set Adresse ID
//        adresse.setId(adresseRepository.findMaxId()+1);
        //set Pays France to Adresse
        Optional<Pays> result1 = paysRepository.findById(paysId);
        Pays pays = result1.get();
        adresse.setPays(pays);
        //set Role = ABONNE
        Optional<Role> result2 = roleRepository.findById(2);
        List<Role> roles = new ArrayList<>();
        roles.add(result2.get());
        abonne.setRoles(roles);
        //set Date de Création Compte
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        abonne.setDateCreationCompte(new Date());
        //save Abonne in DB
        try {
            abonneRepository.save(abonne);
        }catch (DataIntegrityViolationException e) {
            throw new TechnicalException(ErrorMessages.DUPLICATE_KEY_ERROR.getErrorMessage());
        }
    }

    @Override
    public void deleteAbonne(Abonne abonne) {
        abonneRepository.delete(abonne);
    }

    @Override
    public List<Employe> findAllEmploye() throws TechnicalException {
        List<Employe> employes = employeRepository.findAll();
        if (employes == null) {
            throw new TechnicalException("Aucun résultat de recherche");
        } else return employes;
    }

    @Override
    public Employe findEmployeById(int employeId) throws TechnicalException {
        Optional<Employe> result = employeRepository.findById(employeId);
        Employe employe = null;
        if (result.isPresent()) {
            employe = result.get();
        } else throw new TechnicalException("Employe non trouvé");
        return employe;
    }

    @Override
    public void createEmploye(Employe employe) {
        //set Matricule
        employe.setMatricule(UUID.randomUUID().toString());
        //get adresse de l'employe
        Adresse adresse = employe.getAdresse();
        //set Adresse ID
//        adresse.setId(adresseRepository.findMaxId() + 1);
        //set Pays France to Adresse
        Optional<Pays> result1 = paysRepository.findById(1);
        Pays pays = result1.get();
        adresse.setPays(pays);
        //set Role = ADMIN
        Optional<Role> result2 = roleRepository.findById(4);
        List<Role> roles = new ArrayList<>();
        roles.add(result2.get());
        employe.setRoles(roles);
        //Encrypt Password
        employe.setPassword(passwordEncoderHelper.passwordEncoder(employe.getPassword()));
        //Save Employe in DB
        employeRepository.save(employe);
    }

    @Override
    public void deleteEmploye(Employe employe) {
        employeRepository.delete(employe);
    }

    @Override
    public String authenticateUser(UserDetailsDto userDetailsDto) {
        String email = userDetailsDto.getEmail();
        String password = userDetailsDto.getPassword();
        String message = "Le mot de passe est incorrect";
        boolean abonne = false;
        boolean employe = false;
        boolean pwCheck = false;
        List<Abonne> abonnes = abonneRepository.findAll();
        List<Employe> employes = employeRepository.findAll();
        for (Abonne tempAbonne : abonnes
        ) {
            if (tempAbonne.getEmail().equals(userDetailsDto.getEmail())) {
                abonne = true;
                pwCheck = BCrypt.checkpw(password, tempAbonne.getPassword());
            }
            else {
                message = "Cet email n'existe pas";
            }
        }
        for (Employe tempEmploye : employes
        ) {
            if (tempEmploye.getEmail().equals(userDetailsDto.getEmail())) {
                employe = true;
                pwCheck = BCrypt.checkpw(password, tempEmploye.getPassword());
            }
            else {
                message = "Cet email n'existe pas";
            }
        }
        if (pwCheck) {
            message = "Authentification OK";
        }
        return message;
    }
}

