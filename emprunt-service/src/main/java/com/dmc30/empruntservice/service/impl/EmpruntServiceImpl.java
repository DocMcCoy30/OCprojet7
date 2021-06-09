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
import org.springframework.stereotype.Service;

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
     * @param createEmpruntDto les paramètres de l'emprunt
     */
    @Override
    public void createEmprunt(CreateEmpruntDto createEmpruntDto) {
        Ouvrage ouvrage = ouvrageRepository.getById(createEmpruntDto.getOuvrageId());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        OuvrageDto ouvrageDto = modelMapper.map(ouvrage, OuvrageDto.class);
        PretDto pretDto = new PretDto();
        LocalDate dateEmprunt = LocalDate.now();
        pretDto.setDateEmprunt(dateEmprunt);
        LocalDate dateRestitution = LocalDate.now().plusDays(7);
        pretDto.setDateRestitution(dateRestitution);
        LocalDate dateProlongation = LocalDate.now().plusDays(14);
        pretDto.setDateProlongation(dateProlongation);
        pretDto.setProlongation(false);
        pretDto.setOuvrageDto(ouvrageDto);
        Pret pret = modelMapper.map(pretDto, Pret.class);
        pretRepository.save(pret);
    }
}
