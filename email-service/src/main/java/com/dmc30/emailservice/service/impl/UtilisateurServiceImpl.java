package com.dmc30.emailservice.service.impl;

import com.dmc30.emailservice.data.entity.UtilisateurEntity;
import com.dmc30.emailservice.data.repository.UtilisateurRepository;
import com.dmc30.emailservice.service.contract.UtilisateurService;
import com.dmc30.emailservice.service.dto.UtilisateurDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public List<UtilisateurDto> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<UtilisateurDto> utilisateurDtos = new ArrayList<>();
        List<UtilisateurEntity> utilisateurEntities = utilisateurRepository.findAll();
        for (UtilisateurEntity utilisateur : utilisateurEntities) {
            utilisateurDtos.add(modelMapper.map(utilisateur, UtilisateurDto.class));
        }
        return utilisateurDtos;
    }

    @Override
    public UtilisateurDto findById(Long utilisateurId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UtilisateurEntity utilisateurEntity = new UtilisateurEntity();
        Optional<UtilisateurEntity> result = utilisateurRepository.findById(utilisateurId);
        if(result.isPresent()) {
            utilisateurEntity=result.get();
        }
//        UtilisateurDto utilisateurDto = new UtilisateurDto();
//        utilisateurDto.setId(utilisateurEntity.getId());
//        utilisateurDto.setEmail(utilisateurEntity.getEmail());
        return modelMapper.map(utilisateurEntity, UtilisateurDto.class);
    }
}
