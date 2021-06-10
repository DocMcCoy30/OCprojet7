package com.dmc30.empruntservice.service.impl;

import com.dmc30.empruntservice.data.entity.Ouvrage;
import com.dmc30.empruntservice.data.entity.Pret;
import com.dmc30.empruntservice.data.repository.OuvrageRepository;
import com.dmc30.empruntservice.data.repository.PretRepository;
import com.dmc30.empruntservice.dto.CreateEmpruntDto;
import com.dmc30.empruntservice.dto.OuvrageDto;
import com.dmc30.empruntservice.dto.PretDto;
import com.dmc30.empruntservice.service.contract.EmpruntService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Service
public class EmpruntServiceImpl implements EmpruntService {

    OuvrageRepository ouvrageRepository;
    PretRepository pretRepository;

    @Autowired
    public EmpruntServiceImpl(OuvrageRepository ouvrageRepository, PretRepository pretRepository) {
        this.ouvrageRepository = ouvrageRepository;
        this.pretRepository = pretRepository;
    }

    /**
     * Crée un nouvel emprunt dans la base de données
     *
     * @param createEmpruntDto les paramètres de l'emprunt
     */
    @Override
    public PretDto createEmprunt(CreateEmpruntDto createEmpruntDto) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateEmprunt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dateEmprunt);
        c.add(Calendar.DAY_OF_MONTH, 7);
        Date dateRestitution = c.getTime();
        Ouvrage ouvrage = ouvrageRepository.getById(createEmpruntDto.getOuvrageId());
        ouvrage.setEmprunte(true);
        ouvrageRepository.save(ouvrage);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        PretDto pretDto = new PretDto();
        pretDto.setDateEmprunt(dateEmprunt);
        pretDto.setDateRestitution(dateRestitution);
        pretDto.setProlongation(false);
        pretDto.setOuvrageId(ouvrage.getId());
        pretDto.setUtilisateurId(createEmpruntDto.getAbonneId());
        pretRepository.save(modelMapper.map(pretDto, Pret.class));
        return pretDto;
    }
}
