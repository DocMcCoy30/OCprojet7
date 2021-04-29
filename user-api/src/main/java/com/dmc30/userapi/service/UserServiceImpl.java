package com.dmc30.userapi.service;

import com.dmc30.userapi.exception.IntrouvableException;
import com.dmc30.userapi.model.bean.UserAuthenticationBean;
import com.dmc30.userapi.model.entity.*;
import com.dmc30.userapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    AbonneRepository abonneRepository;
    EmployeRepository employeRepository;
    AdresseRepository adresseRepository;
    PaysRepository paysRepository;
    RoleRepository roleRepository;
    BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(AbonneRepository abonneRepository, EmployeRepository employeRepository, AdresseRepository adresseRepository, PaysRepository paysRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.abonneRepository = abonneRepository;
        this.employeRepository = employeRepository;
        this.adresseRepository = adresseRepository;
        this.paysRepository = paysRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Abonne> findAllAbonne() {
        List<Abonne> abonnes = abonneRepository.findAll();
        if (abonnes == null) {
            throw new IntrouvableException("Aucun résultat de recherche");
        } else return abonnes;
    }

    @Override
    public Abonne findAbonneById(int abonneId) {
        Optional<Abonne> result = abonneRepository.findById(abonneId);
        Abonne abonne = null;
        if (result.isPresent()) {
            abonne = result.get();
        } else throw new IntrouvableException("Abonne non trouvé");
        return abonne;
    }

    @Override
    public void createAbonne(Abonne abonne) {
        //set Numero Abonne
        abonne.setNumAbonne(UUID.randomUUID().toString());
        //get Adresse de l'abonné
        Adresse adresse = abonne.getAdresse();
        //set Adresse ID
//        adresse.setId(adresseRepository.findMaxId()+1);
        //set Pays France to Adresse
        Optional<Pays> result1 = paysRepository.findById(1);
        Pays pays = result1.get();
        adresse.setPays(pays);
        //set Role = ABONNE
        Optional<Role> result2 = roleRepository.findById(2);
        List<Role> roles = new ArrayList<>();
        roles.add(result2.get());
        abonne.setRoles(roles);
        //Encrypt Password
        abonne.setPassword(passwordEncoder.encode(abonne.getPassword()));
        //save Abonne in DB
        abonneRepository.save(abonne);
    }

    @Override
    public void deleteAbonne(Abonne abonne) {
        abonneRepository.delete(abonne);
    }

    @Override
    public List<Employe> findAllEmploye() {
        List<Employe> employes = employeRepository.findAll();
        if (employes == null) {
            throw new IntrouvableException("Aucun résultat de recherche");
        } else return employes;
    }

    @Override
    public Employe findEmployeById(int employeId) {
        Optional<Employe> result = employeRepository.findById(employeId);
        Employe employe = null;
        if (result.isPresent()) {
            employe = result.get();
        } else throw new IntrouvableException("Employe non trouvé");
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


        //Save Employe in DB
        employeRepository.save(employe);
    }

    @Override
    public void deleteEmploye(Employe employe) {
        employeRepository.delete(employe);
    }

    @Override
    public String authenticateUser(UserAuthenticationBean userAuthenticationBean) {
        String username = userAuthenticationBean.getUsername();
        String password = userAuthenticationBean.getPassword();
        String result = "Authentification KO";
        boolean abonne = false;
        boolean employe = false;
        boolean pwCheck = false;
        List<Abonne> abonnes = abonneRepository.findAll();
        List<Employe> employes = employeRepository.findAll();
        for (Abonne tempAbonne : abonnes
        ) {
            if (tempAbonne.getUsername().equals(userAuthenticationBean.getUsername())) {
                abonne = true;
                pwCheck = BCrypt.checkpw(password, tempAbonne.getPassword());
            }
        }
        for (Employe tempEmploye : employes
        ) {
            if (tempEmploye.getUsername().equals(userAuthenticationBean.getUsername())) {
                employe = true;
                pwCheck = BCrypt.checkpw(password, tempEmploye.getPassword());
            }
        }
        if (pwCheck) {
            result = "Authentification OK";
        }
        return result;
    }
}

