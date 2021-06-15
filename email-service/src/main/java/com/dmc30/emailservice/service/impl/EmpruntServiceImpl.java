package com.dmc30.emailservice.service.impl;

import com.dmc30.emailservice.data.entity.PretEntity;
import com.dmc30.emailservice.data.repository.PretRepository;
import com.dmc30.emailservice.service.contract.EmpruntService;
import com.dmc30.emailservice.service.dto.PretDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpruntServiceImpl implements EmpruntService {

    PretRepository pretRepository;

    @Autowired
    public EmpruntServiceImpl(PretRepository pretRepository) {
        this.pretRepository = pretRepository;
    }

    @Override
    public List<PretDto> findExpiredPrets() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<PretDto> pretDtos = new ArrayList<>();
        List<PretEntity> pretEntities = pretRepository.findExpiredPrets();
        for (PretEntity pretEntity:pretEntities) {
            pretDtos.add(modelMapper.map(pretEntity, PretDto.class));
        }
        return pretDtos;
    }
}
