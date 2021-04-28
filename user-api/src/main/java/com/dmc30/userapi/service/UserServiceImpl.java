package com.dmc30.userapi.service;

import com.dmc30.userapi.exception.IntrouvableException;
import com.dmc30.userapi.model.entity.*;
import com.dmc30.userapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    AbonneRepository abonneRepository;
    EmployeRepository employeRepository;
    AdresseRepository adresseRepository;
    PaysRepository paysRepository;
    RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(AbonneRepository abonneRepository, EmployeRepository employeRepository, AdresseRepository adresseRepository, PaysRepository paysRepository, RoleRepository roleRepository) {
        this.abonneRepository = abonneRepository;
        this.employeRepository = employeRepository;
        this.adresseRepository = adresseRepository;
        this.paysRepository = paysRepository;
        this.roleRepository = roleRepository;
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
        employe.setMatricule(UUID.randomUUID().toString());
        Adresse adresse = employe.getAdresse();
        Optional<Pays> result1 = paysRepository.findById(1);
        Pays pays = result1.get();
        adresse.setPays(pays);
        Optional<Role> result2 = roleRepository.findById(4);
        List<Role> roles= new ArrayList<>();
        roles.add(result2.get());
        employe.setRole(roles);
        employeRepository.save(employe);
    }

    @Override
    public void deleteEmploye(Employe employe) {
        employeRepository.delete(employe);
    }
}
