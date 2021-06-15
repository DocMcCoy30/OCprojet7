package com.dmc30.emailservice.service.impl;

import com.dmc30.emailservice.data.entity.LivreEntity;
import com.dmc30.emailservice.data.entity.OuvrageEntity;
import com.dmc30.emailservice.data.repository.LivreRepository;
import com.dmc30.emailservice.data.repository.OuvrageRepository;
import com.dmc30.emailservice.service.contract.LivreService;
import com.dmc30.emailservice.service.dto.LivreForMailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivreServiceImpl implements LivreService {

    OuvrageRepository ouvrageRepository;
    LivreRepository livreRepository;

    @Autowired
    public LivreServiceImpl(OuvrageRepository ouvrageRepository, LivreRepository livreRepository) {
        this.ouvrageRepository = ouvrageRepository;
        this.livreRepository = livreRepository;
    }

    @Override
    public LivreForMailDto getTitreDuLivre(Long ouvrageId) {
        LivreForMailDto livre = new LivreForMailDto();
        OuvrageEntity ouvrageEntity = ouvrageRepository.getById(ouvrageId);
        LivreEntity livreEntity = livreRepository.getById(ouvrageEntity.getLivreId());
        String titre = livreEntity.getTitre();
        livre.setTitre(titre);
        return livre;
    }
}
