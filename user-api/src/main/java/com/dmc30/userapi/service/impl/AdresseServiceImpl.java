package com.dmc30.userapi.service.impl;

import com.dmc30.userapi.exception.TechnicalException;
import com.dmc30.userapi.model.entity.Adresse;
import com.dmc30.userapi.repository.AdresseRepository;
import com.dmc30.userapi.service.contract.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdresseServiceImpl implements AdresseService {

    AdresseRepository adresseRepository;

    @Autowired
    public AdresseServiceImpl(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }

    @Override
    public Adresse findAdresseById(int adresseId) throws TechnicalException {
        Optional<Adresse> result = adresseRepository.findById(adresseId);
        Adresse adresse = null;
        if (result.isPresent()) {
            adresse = result.get();
        }else throw new TechnicalException("L'adresse est introuvable!");
        return adresse;
    }

    @Override
    public void createAdresse(Adresse adresse) {
        adresseRepository.save(adresse);
    }

    @Override
    public Integer findMaxId() {
        return adresseRepository.findMaxId();
    }

}
